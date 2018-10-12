package com.dogfriend.controller;

import com.dogfriend.domain.TempHumiVO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	//controller + reponseBody 객체를 리턴하면 json으로 출력 자바객체를 json으로 변환(?)
@RequestMapping("/")
public class ViewController {

	private TempHumiVO temHum = new TempHumiVO();	//temp humi 값 저장할 객체 생성
	
	@PostMapping("/setTempHumi")	//온습도 requestMapping + mothod post	//@RequestBody 자바 객체를 만들어준다.
	public ResponseEntity<String> revArduinoTempHumi(@RequestBody TempHumiVO vo) {	//아두이노에서 온 값을 @RequestBody는 자바객체로 만들어 vo담음
		try {
				temHum.setTemp(vo.getTemp());	//body에서 읽은 값 set해주기
				temHum.setHumi(vo.getHumi());
				System.out.println("temp = " + temHum.getTemp() + " humi = " + temHum.getHumi());	//출력

			return new ResponseEntity<>("success",HttpStatus.OK);	//성공시 success에 ok를 담는다.

		} catch (Exception e) {
			e.printStackTrace(); //예외 오류
			return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST); //성공시 fail bad 담는다.
		}
	}

	@GetMapping("/view")	//안드로이드가 온습도를 볼때 콜해야 할 주소
	public ResponseEntity<TempHumiVO> sendAndroid() { //안드로이드에서 온 값을 @RequestBody는 자바객체로 만들어 vo담음
		try {
			return new ResponseEntity<>(temHum, HttpStatus.OK);	// 전역변수 temHum인 json을 통째로 리턴보낸다.
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}