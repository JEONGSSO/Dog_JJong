package com.dogfriend.controller;

import java.util.HashMap;
import java.util.Map;

import com.dogfriend.domain.HandleVO;
import com.dogfriend.domain.TempHumiVO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HandleController{

	HandleVO handle = new HandleVO();

////////////////////////////안드로이드에서 버튼 자동제어 온오프 눌렀을 때////////////////////////////////////
	@PostMapping("/setpower")	//안드로이드가 자동제어 온오프 누를때 콜해야 할 주소
	public ResponseEntity<HandleVO> revdAndroid(@RequestBody HandleVO handle) {	//아두이노에서 온 값을 @RequestBody는 자바객체로 만들어 vo담음
		
		handle.setPower(handle.isPower());	//power 받아오면 값을 담아준다.
		
		try {
			return new ResponseEntity<>(handle, HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

////////////////////////////안드로이드에서 버튼 눌렀을 때 아두이노로 보내기////////////////////////////////////
	@GetMapping("/sendarduino")	//온습도 requestMapping + mothod post	//@RequestBody 자바 객체를 만들어준다.
	public ResponseEntity<String> sendArduinoTempHumi() {	

		try {
			return new ResponseEntity<>(handle,HttpStatus.OK);	//성공시 success에 ok를 담는다.

		} catch (Exception e) {
			e.printStackTrace(); //예외 오류
			return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST); //성공시 fail bad 담는다.
		}
	}

	@GetMapping("/ctrl")
	public Map<Integer,Boolean> autoCotrol() 	//통신규약 정하기
	{

		HashMap<Integer, Boolean> hashMap = new HashMap<>();
		hashMap.put(1, true);
		hashMap.put(2, false);
		
		return hashMap;
	}
}