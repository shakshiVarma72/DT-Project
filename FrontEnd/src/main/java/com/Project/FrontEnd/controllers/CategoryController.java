package com.Project.FrontEnd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategoryController {
	
	@RequestMapping(value="/admin/getaddcategory",method=RequestMethod.GET)
	public String getcategoryForm(ModelMap map){
		System.out.println(" I AM ADD ");
		return "AddCategory";
	}
	
	@RequestMapping(value="/submitCategory",method=RequestMethod.GET)
public String SubmitAddProduct(@RequestParam("categoryNAme")String categoryName,ModelMap map) {
		Category cat=
		return "viewAllCategory";
	}

	@RequestMapping(value="getviewcategory",method=RequestMethod.GET)
	public String getviewcategory(ModelMap map){
		System.out.println(" I AM ADD ");
		return "viewAllCategory";
	
}
}