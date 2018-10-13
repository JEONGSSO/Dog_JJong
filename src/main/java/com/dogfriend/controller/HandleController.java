package com.dogfriend.controller;

import com.dogfriend.domain.HandleVO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HandleController{

	HandleVO handle = new HandleVO();

////////////////////////////안드로이드에서 버튼 전원 온오프 눌렀을 때////////////////////////////////////
	@PostMapping("/setpower")	//안드로이드가 전원 온오프 누를때 콜해야 할 주소
	public ResponseEntity<HandleVO> setAndroidPower(@RequestBody HandleVO handle) {	//아두이노에서 온 값을 @RequestBody는 자바객체로 만들어 vo담음
		
		handle.setPower(handle.isPower());	//power 받아오면 값을 담아준다. boolean은 isPower == setPower
		
		try {
			return new ResponseEntity<>(handle, HttpStatus.OK);		//받은 값 통째로 아두이노 리턴
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

////////////////////////////아두이노로 전원여부 값 전달////////////////////////////////////
	@GetMapping("/sendpower")
	public ResponseEntity<String> sendArduinoTempHumi() {	

		try {
			return new ResponseEntity<>("Power Send Ok",HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Power Send Fail",HttpStatus.BAD_REQUEST);
		}
	}

	//만약 컨트롤러를 나누면 set, send끼리 나눌지 power, auto 기능끼리 나눌지 상의

///////////////////////////안드로이드에서 자동모드 클릭했을 때/////////////////////////////////////////////////////
	@PostMapping("/setautomode")
	public ResponseEntity<HandleVO> autoMode(@RequestBody HandleVO handle)
	{
		handle.setAutoMode(handle.isAutoMode());	//boolean 타입

		try{
			return new ResponseEntity<>(handle, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

///////////////////////////아두이노로 자동모드 값 전달//////////////////////////////////////////////////////////////
	@GetMapping("/sendauto")
	public ResponseEntity<String> sendArduinoAutoMode() {	

		try {
			return new ResponseEntity<>("autoMode OK",HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("autoMode Fail",HttpStatus.BAD_REQUEST);
		}
	}
}