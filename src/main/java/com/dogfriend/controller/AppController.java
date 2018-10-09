package com.dogfriend.controller;

import java.util.HashMap;
import java.util.Map;

import com.dogfriend.domain.tempHumiVO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	//controller + reponseBody 객체를 리턴하면 json으로 출력
@RequestMapping("/dog")
public class AppController {
	
	@GetMapping("/view/{temp}/{humi}")	//온습도 requestMapping + mothod get
	public tempHumiVO tempHumi(@PathVariable("temp") String temp,
							   @PathVariable("humi") String humi ) {
		tempHumiVO temHum = new tempHumiVO();
		temHum.setTemp(temp);
		temHum.setHumi(humi);
		return temHum;
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