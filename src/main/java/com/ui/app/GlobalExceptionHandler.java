package com.ui.app;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ResourceAccessException.class)
	public ModelAndView handleConnectionException() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error");
		mv.addObject("errorResponse","Product Services are down, check with admin");
		
		return mv;
	}
	
}
