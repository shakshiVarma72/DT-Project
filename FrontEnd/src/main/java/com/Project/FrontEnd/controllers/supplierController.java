package com.Project.FrontEnd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlineshop.BackEnd2.Dao.SupplierDao;
import com.onlineshop.BackEnd2.dto.Supplier;
@Controller
public class supplierController {
	
	@Autowired 
SupplierDao supplierDao;
	
  @RequestMapping(value="/admin/getaddsupplier",method=RequestMethod.GET)
	public String getSupplierForm(ModelMap map){
		System.out.println(" I AM ADD supplier");
		return "AddSupplier";
	}
	 
  @RequestMapping(value="/admin/submitSupplier",method=RequestMethod.POST)
    public String SubmitForm(@RequestParam("supplierName")String supplierName,ModelMap map) {
		Supplier supp1=new Supplier();
		supp1.setSupplierName(supplierName);
	
       System.out.println("category Added Succesfully");	
         boolean supp2=supplierDao.addSupplier(supp1);
         if(supp2==true) {
	return "success"; }
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


