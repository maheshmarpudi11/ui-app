package com.ui.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@RequestMapping("/")
	public ModelAndView getWelcomePage() {
		System.out.println("WelcomeController -> getWelcomePage : starts");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		mv.addObject("message", "Spring Boot Applications");
		
		System.out.println("WelcomeController -> getWelcomePage : ends");
		return mv;
	}

}
