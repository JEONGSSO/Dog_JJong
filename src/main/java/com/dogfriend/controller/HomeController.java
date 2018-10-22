package com.dogfriend.controller;

import java.util.List;

import com.dogfriend.Persistent.JpaDao;
import com.dogfriend.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {

	
	@GetMapping("/")
	public String dogHome() {
		return "dogHome";				//webapp/WEB-INF/views/dogHome.jsp실행
	}
	// @Autowired
	// JpaDao dao;
	
	// @PostMapping("/regist")
	// @ResponseBody
	// public User regist(@RequestBody User user) {
	// 	dao.save(user);
	// 	System.out.println("가입되었습니다.");
	// 	return user;
	// }

	// @RequestMapping("/list")
	// @ResponseBody
    // public List<User> userList(Model model) {
    //     List<User> users = dao.findAll();
    //     model.addAttribute("list", users);

    //     return users;
    // }
}

