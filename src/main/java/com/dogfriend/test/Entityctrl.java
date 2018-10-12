package com.dogfriend.test;


import java.util.ArrayList;
import java.util.List;

import com.dogfriend.domain.TempHumiVO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/dog")
@RestController	//controller + reponseBody 객체를 리턴하면 json으로 출력
public class Entityctrl {
	
	@GetMapping("/sendlist") //requestMapping + mothod get	안쓰는거
	// public void send(){
	public ResponseEntity<List<TempHumiVO>> sendList() {
		List <TempHumiVO> list = new ArrayList<>();
		TempHumiVO tmpHum = new TempHumiVO();

		tmpHum.setTemp(0);
		tmpHum.setHumi(20);
		
		list.add(tmpHum);

		if(!list.isEmpty())
			return new ResponseEntity<>(list, HttpStatus.OK);
		else 
			return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
	}
}