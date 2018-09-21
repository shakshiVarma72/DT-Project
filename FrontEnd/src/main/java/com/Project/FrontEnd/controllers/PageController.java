package com.Project.FrontEnd.controllers;


import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.onlineshop.BackEnd2.Dao.CategoryDao;
import com.onlineshop.BackEnd2.Dao.ProductDao;
import com.onlineshop.BackEnd2.Dao.SupplierDao;
import com.onlineshop.BackEnd2.Dao.UserDao;
import com.onlineshop.BackEnd2.dto.Category;
import com.onlineshop.BackEnd2.dto.User;

@Controller
public class PageController {
	@Autowired
	@Qualifier("productDao")
	ProductDao productDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	SupplierDao supplierDao;
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView getHomePage() {
		ModelAndView mv=new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping(value="/admin/adminHomePage",method=RequestMethod.GET)
	public String getAdminHomePage() {
		System.out.println("Admin Home Page");
		return "AdminHomePage";
	}
	@RequestMapping(value="/admin/getProductPage",method=RequestMethod.GET)
	public String getProductPage() {
		return "ProductPage"; 
	}
	

	@RequestMapping(value="/admin/getcategoryPage",method=RequestMethod.GET)
	public String getCategoryPage() {
		return "categoryPage"; 
	}
	@RequestMapping(value="/admin/getSupplierPage",method=RequestMethod.GET)
	public String getSupplierPage() {
		return "SupplierPage"; 
	}
	
/*/@RequestMapping(value="/login",method=RequestMethod.GET)
public ModelAndView getAdminForm(@RequestParam(name="error",required=false)String error) {
	System.out.println("I Am Admin Form");	

ModelAndView mv=new ModelAndView("Login");
if(error!=null){
	mv.addObject("message","Username or Password is Incorrect");
}
return mv;
}
*/
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView getLoginForm(@RequestParam(name="error",required=false)String error,
			@RequestParam(name="logout",required=false)String logout){
		System.out.println("I m in getLogin Form method");
		ModelAndView mv=new ModelAndView("Login");
		if(error!=null){
			
			mv.addObject("message","Username or password is incorrect");
		}
		if(logout!=null){
			mv.addObject("message","User has succesfully logged out!!");
		}
		
		return mv;
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView getSignUpForm(){
		ModelAndView mv=new ModelAndView("SignUpForm");
		mv.addObject("userObj",new User());
		return mv;
	}
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String addUserProcess(@Valid @ModelAttribute("userObj")User userObj,
			BindingResult result,ModelMap map){
		try{
			
			if(result.hasErrors()) {
				return "SignUpForm";
			}
			
		System.out.println("I m here in add User method");
		userObj.setRole("USER");
		userObj.setEnabled(true);
		userDao.registerUser(userObj);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		map.addAttribute("message","User Registered Succesfully..");
		return "LoginSuccess";
	}
	
	@RequestMapping(value="/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");		
		mv.addObject("errorTitle", "Aha! Caught You.");		
		mv.addObject("errorDescription", "You are not authorized to view this page!");		
		mv.addObject("title", "403 Access Denied");		
		return mv;
	}	
	@RequestMapping(value="/perform-logout")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		
		//first we are going to fetch the authentication
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
			
		}
		return "redirect:/login?logout";
	}
	@RequestMapping(value="/getProduct/{category}",method=RequestMethod.GET)
	public ModelAndView getProductsByCategory(@PathVariable("category")String cat){
		int catid=0;
		System.out.println("Category : "+cat);
		
		List<Category> categoryList=categoryDao.list();
		for(Category category:categoryList) {
			if(category.getCategoryName().equals(cat)) {
				catid=category.getCategoryId();
			}
		}
		ModelAndView mv=new ModelAndView("viewAll");
		mv.addObject("productList",productDao.getProductsByCategory(catid));
		
		return mv;
	}
}



