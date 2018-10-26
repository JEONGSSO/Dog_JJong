package com.dogfriend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/arduino")	
@RestController
public class ArduinoController{

////////////////////////////아두이노로 자동, 수동조작  전달////////////////////////////////////
	@GetMapping("/handle")	//아두이노가 동작 받을때 콜해야 할 주소
		public int rcvArduinoHandle() {
		return AndroidController.mode;	// 안드로이드가 지정한 모드를 int로 반환해준다.
	}

/*//////////////////////////아두이노로 수동모드 값 전달//////////////////////////////////////////////////////////////
	@GetMapping("/manual")	//아두이노가 받을때 콜해야 할 주소
	public ResponseEntity<Boolean> sendArduinoManual() {	

		try {
			boolean manual = handle.isManual();
			return new ResponseEntity<>(manual, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}*/

/*///////////////////////////아두이노로 전원, 수동여부  전달////////////////////////////////////
@GetMapping("/handle")	//아두이노가 전원여부 받을때 콜해야 할 주소
public HandleVO rcvArduinoHandle() {	

	return handle;	// power, manual 아두이노에게 리턴

	// try {
		// boolean Power = handle.isPower();
		// return new ResponseEntity<>(Power, HttpStatus.OK);
		

	// } catch (Exception e) {
	// 	// return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	// 	return null;
	// }
}*/

}
