package com.dogfriend.controller;

import com.dogfriend.domain.HandleVO;
import com.dogfriend.domain.TempHumiVO;

import org.springframework.asm.Handle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String dogHome() {
	return "dogHome";	//webapp/WEB-INF/views/dogHome.jsp실행
	}

	@GetMapping("/view2")	//안드로이드가 온습도를 볼때 콜해야 할 주소
	public void sendAndroid(Model model) {
		TempHumiVO temHumVo = new TempHumiVO();
		HandleVO handle  = new HandleVO();
			// System.out.println(temHumVo);
			model.addAttribute("temp", temHumVo.getTemp());
			model.addAttribute("humi", temHumVo.getHumi());
			model.addAttribute("power", handle.getPower());
			model.addAttribute("manual", handle.isManual());

	}

}

