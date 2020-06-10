package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeResource {
	@ResponseBody
	@RequestMapping("/")
	public String home() {
		return "All registered users";
	}
	@ResponseBody
	@RequestMapping("/user")
	public String user() {
		return "Admin user and user with user role";
	}
	@ResponseBody
	@RequestMapping("/admin")
	public String admin() {
		return "Admin users";
	}
}
