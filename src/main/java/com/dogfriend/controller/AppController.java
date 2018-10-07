package com.dogfriend.controller;


import com.dogfriend.domain.DogfriendVO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/dog")
@RestController	//controller + reponseBody 객체를 리턴하면 json으로 출력
public class AppController {
	
	@GetMapping("/{temp}/{humi}")	//requestMapping + mothod get
	public DogfriendVO tempHumi(@PathVariable("temp") String temp,
						   @PathVariable("humi") String humi ) {
		DogfriendVO dogvo = new DogfriendVO();
		dogvo.setTemp(temp);
		dogvo.setHumi(humi);
		return dogvo;
	}
}