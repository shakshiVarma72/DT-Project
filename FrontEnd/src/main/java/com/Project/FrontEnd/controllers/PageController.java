package com.Project.FrontEnd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView getHomePage() {
		ModelAndView mv=new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping(value="/adminHomePage",method=RequestMethod.GET)
	public String getAdminHomePage() {
		System.out.println("Admin Home Page");
		return "AdminHomePage";
	}

	@RequestMapping(value="/getcategoryPage",method=RequestMethod.GET)
	public String getCategoryPage() {
		return "categoryPage"; 
	}
	@RequestMapping(value="/getSupplierPage",method=RequestMethod.GET)
	public String getSupplierPage() {
		return "SupplierPage"; 
	}
	
/*@RequestMapping(value="/login",method=RequestMethod.GET)
public ModelAndView getAdminForm(@RequestParam(name="error",required=false)String error) {
	System.out.println("I Am Admin Form");	

ModelAndView mv=new ModelAndView("Login");
if(error!=null){
	mv.addObject("message","Username or Password is Incorrect");
}
return mv;
}
}*/
}

