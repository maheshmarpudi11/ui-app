package com.ui.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

	@RequestMapping("/product-dashboard")
	public ModelAndView getProductDashboard() {
		
		System.out.println("ProductController -> getProductDashboard : starts");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product-dashboard");
		mv.addObject("message1", "Product Dashboard");
		mv.addObject("message2", "Product Services");
		
		System.out.println("ProductController -> getProductDashboard : starts");
		
		return mv;
		
	}
	
	
}
