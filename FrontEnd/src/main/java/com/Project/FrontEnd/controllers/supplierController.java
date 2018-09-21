package com.Project.FrontEnd.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

import com.onlineshop.BackEnd2.Dao.SupplierDao;
import com.onlineshop.BackEnd2.dto.Supplier;


@Controller
public class supplierController {
	
	@Autowired 
SupplierDao supplierDao;
	
  @RequestMapping(value="/admin/getaddsupplier",method=RequestMethod.GET)
	public ModelAndView getSupplierForm(ModelMap map){
		System.out.println(" I AM ADD supplier");
		ModelAndView mv=new ModelAndView("AddSupplier");
		mv.addObject("supplierObj",new Supplier());
		return mv;
	}
	 
  @RequestMapping(value="/admin/submitSupplier",method=RequestMethod.POST)
    public String SubmitForm(@ModelAttribute("supplierObj")Supplier supplierObj,ModelMap map) {
	     boolean supp2=supplierDao.addSupplier(supplierObj);
         if(supp2==true) {
	return "redirect:getviewSupplier"; }
    else 
    return "Failure";
  }
	
  @RequestMapping(value="/admin/getviewSupplier",method=RequestMethod.GET)
	public String getviewcategory(ModelMap map){
		System.out.println(" I AM ADD ");
		List<Supplier>  supp2=supplierDao.listSupplier();
		map.addAttribute("supplierList", supp2);
		return "viewAllSupplier";}	
  

	
}


