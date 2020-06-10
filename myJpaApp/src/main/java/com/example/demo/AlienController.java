package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@Controller
public class AlienController {

	@Autowired
	AlienRepo alienRepo;
	
	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.jsp");
		return mv;
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		System.out.println("Going to add Id="+alien.getAid()+" and Name="+alien.getAname());
		alienRepo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		mv.addObject(alienRepo.findById(aid).orElse(new Alien()));
		return mv;
	}
	
	@RequestMapping("/getAlienByTech")
	public ModelAndView getAlienByTech(@RequestParam String tech) {
		ModelAndView mv = new ModelAndView("showAllAliens.jsp");
		List<Alien> aliens = alienRepo.findByTech(tech); 
		mv.addObject(aliens);
		return mv;
	}
}
