package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping("home")
	public ModelAndView home(Alien alien) {
		System.out.println("Hi from home controller - home method");
		ModelAndView modelAndViewObject = new ModelAndView();
		modelAndViewObject.addObject("obj", alien);
		modelAndViewObject.setViewName("home");
		return modelAndViewObject;
	}

}
