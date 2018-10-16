package com.dogfriend.controller;

import com.dogfriend.domain.HandleVO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/arduino")	
@RestController
public class ArduinoController{

	HandleVO handle = new HandleVO();

////////////////////////////아두이노로 전원여부 값 전달////////////////////////////////////
	@GetMapping("/power")	
	public ResponseEntity<String> sendArduinoPower() {	

		try {
			return new ResponseEntity<>("Power Send Ok",HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Power Send Fail",HttpStatus.BAD_REQUEST);
		}
	}

///////////////////////////아두이노로 자동모드 값 전달//////////////////////////////////////////////////////////////
	@GetMapping("/auto")
	public ResponseEntity<String> sendArduinoAutoMode() {	

		try {
			return new ResponseEntity<>("autoMode OK",HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("autoMode Fail",HttpStatus.BAD_REQUEST);
		}
	}
}
