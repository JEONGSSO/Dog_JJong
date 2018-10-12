package com.dogfriend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HandleController{

    @GetMapping("/ctrl")
	public Map<Integer,Boolean> autoCotrol() 	//통신규약 정하기
	{

		HashMap<Integer, Boolean> hashMap = new HashMap<>();
		hashMap.put(1, true);
		hashMap.put(2, false);
		
		return hashMap;
	}
}