package com.dogfriend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	//controller + reponseBody 객체를 리턴하면 json으로 출력
public class HomeController {

	@RequestMapping("/") //requestMapping + mothod get
	public String dogHome() {
	return "dogHome";	//webapp/WEB-INF/views/dogHome.jsp실행
	}
	
}

