package com.dogfriend.controller;


import java.util.ArrayList;
import java.util.List;

import com.dogfriend.domain.tempHumiVO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/dog")
@RestController	//controller + reponseBody 객체를 리턴하면 json으로 출력
public class Entityctrl {
	
	@GetMapping("/sendlist") //requestMapping + mothod get
	public ResponseEntity<List<tempHumiVO>> sendList() {
		List <tempHumiVO> list = new ArrayList<>();
		tempHumiVO tmpHum = new tempHumiVO();

		tmpHum.setTemp(null);
		tmpHum.setHumi("20.3");
		
		list.add(tmpHum);

		String x = tmpHum.getTemp();
		if(x != null)
			return new ResponseEntity<>(list, HttpStatus.OK);
		else 
			return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
	}
}