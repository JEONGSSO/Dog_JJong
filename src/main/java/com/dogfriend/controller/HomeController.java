package com.dogfriend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String dogHome() {
	return "dogHome";	//webapp/WEB-INF/views/dogHome.jsp실행
	}

}

