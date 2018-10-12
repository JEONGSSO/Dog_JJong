package com.dogfriend.test;

import javax.servlet.http.HttpServletRequest;

import com.dogfriend.domain.TempHumiVO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//컨트롤러 붙이니 에러났다.
@RestController
public class test{

	TempHumiVO vo = new TempHumiVO();

@RequestMapping("/test") //requestMapping + mothod get
	public String jsptest(Model model,
						@RequestParam(value="test")String test) {
	model.addAttribute("message", test);
	return "/test";
	}

	@RequestMapping("/vue")
	public String vueTest() {
		return "/vueTest";
	}

	@PostMapping("/post")
	public String postTest(HttpServletRequest res, Model model)
	{
		String name = res.getParameter("name");
		model.addAttribute("name", name);
		System.out.println(name);
		return "/post";
	}
	
	@PostMapping("/ㄴㅇㅁㅇㄴㅁㅇ")
	public String post(@RequestParam String name) 
	{
		return "dddsdsda " + name;
	}


	@PostMapping("/viewtestttttt")
	public ResponseEntity<String> teststs(@RequestBody TempHumiVO temp){	//리퀘스트 바디는 온 값을 자바객체로
		temp.setHumi(temp.getHumi());
		temp.setTemp(temp.getTemp());

		try {
			return new ResponseEntity<>("성공", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("실패", HttpStatus.BAD_REQUEST);
		}
		
	}

}