package com.dogfriend.controller;

import java.util.HashMap;
import java.util.Map;

import com.dogfriend.domain.TempHumiVO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	//controller + reponseBody 객체를 리턴하면 json으로 출력
@RequestMapping("/")
public class AppController {

	private TempHumiVO temHum = new TempHumiVO();	//담겨서 안드로이드가 읽으면 된다.
	
	@PostMapping("/setTempHumi")	//온습도 requestMapping + mothod get
	public ResponseEntity<String> revArduinoTempHumi(@RequestBody TempHumiVO vo) {
		try {
				temHum.setTemp(vo.getTemp());	//body에서 읽은 값 set해주기
				temHum.setHumi(vo.getHumi());
				System.out.println("temp = " + temHum.getTemp() + "humi = " + temHum.getHumi());
			return new ResponseEntity<>("success",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/view")	//온습도 requestMapping + mothod get
	public ResponseEntity<TempHumiVO> sendAndroid(@RequestBody TempHumiVO vo) {
		try {
			return new ResponseEntity<>(temHum, HttpStatus.OK);	//리턴 보낼때 전역변수 temHum인 vo를 리턴보낸다
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/ctrl")
	public Map<Integer,Boolean> autoCotrol() 
	{
		HashMap<Integer, Boolean> hashMap = new HashMap<>();
		hashMap.put(1, true);
		hashMap.put(2, false);
		
		return hashMap;
	}

	
}