package com.dogfriend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller	//controller + reponseBody 객체를 리턴하면 json으로 출력
public class jspTest {
	@GetMapping("/test") //requestMapping + mothod get
	public String jsptest() {
		return "test";
	}
}