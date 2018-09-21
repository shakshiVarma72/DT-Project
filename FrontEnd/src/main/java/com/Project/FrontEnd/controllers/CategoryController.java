package com.Project.FrontEnd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.onlineshop.BackEnd2.Dao.CategoryDao;
import com.onlineshop.BackEnd2.dto.Category;

  @Controller
  public class CategoryController {
	@Autowired 
	CategoryDao categoryDao;
	
  @RequestMapping(value="/admin/getaddcategory",method=RequestMethod.GET)
	public ModelAndView getcategoryForm(){
		System.out.println(" I AM ADD ");
		
		ModelAndView mv=new ModelAndView("AddCategory");
		mv.addObject("categoryObj",new Category());
		return mv;
	}
  
  
  @RequestMapping(value="/admin/addCategory",method=RequestMethod.POST)
    public String SubmitForm(@ModelAttribute("categoryObj")Category categoryObj,ModelMap map) {
	  
	  System.out.println("I m Submit Category page "+categoryObj.getCategoryName()+" "+categoryObj.getCategoryDesc());
         boolean cat1=categoryDao.addCategory(categoryObj);
         if(cat1==true) {
        	map.addAttribute("msg","Category Added Succesfully");
	return "redirect:getviewcategory"; }
    else 
    return "Failure";
  }
	

  @RequestMapping(value="/admin/getviewcategory",method=RequestMethod.GET)
	public String getviewcategory(ModelMap map){
		System.out.println(" I AM ADD ");
		List<Category> cat2=categoryDao.list();
		map.addAttribute("categoryList", cat2);
		return "viewAllCategory";}	
  
  @RequestMapping(value="admin/deletecategory/{catId}",method=RequestMethod.GET)
  public String DeleteCategory(@PathVariable("catId")int categoryId,ModelMap map) {
	  categoryDao.deleteCategory(categoryId);
  	map.addAttribute("msg","Category Deleted Succesfully..");
  	return "redirect:/admin/viewAllCategory";
  	
}}