package com.Project.FrontEnd.controllers;



import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.onlineshop.BackEnd2.Dao.CategoryDao;
import com.onlineshop.BackEnd2.Dao.ProductDao;
import com.onlineshop.BackEnd2.Dao.SupplierDao;
import com.onlineshop.BackEnd2.dto.Category;
import com.onlineshop.BackEnd2.dto.Product;
import com.onlineshop.BackEnd2.dto.Supplier;



@Controller
public class ProductController {

	
	
	@Autowired
	@Qualifier("productDao")
	ProductDao productDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	SupplierDao supplierDao;
	
	
	/*add product*/
	@RequestMapping(value="/admin/getaddproduct",method=RequestMethod.GET)
	public ModelAndView getProductForm(){
		System.out.println(" I AM ADD ");
		
		ModelAndView mv=new ModelAndView("ProductForm2");
		List<Category> categories=categoryDao.list();
	    
		List<Supplier> suppliers=supplierDao .listSupplier();
		
		mv.addObject("supplierList",suppliers);
		
		 mv.addObject("categoryList",categories);
		 mv.addObject("productObj",new Product());
		 
		 for(Category cat:categories) {
			 System.out.println("I AM LOOP");
	 			System.out.println("HELLO"+cat.getCategoryName());
			}
		 
		return mv;
		}
	/*@RequestMapping(value="submit",method=RequestMethod.GET)
public String SubmitAddProduct(@ModelAttribute("ProForm")Product ProForm,ModelMap map) {
	map.addAttribute("proObj",ProForm);	
	
	boolean Pro1=productDao.addProduct(ProForm);
	if(Pro1==true) {
		return"success";
	}
	else {
		return"Failure";
		
	}
	
	}	*/

	@RequestMapping(value="/admin/addProduct",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product,
	ModelMap map,HttpSession session){
	System.out.println("I am add PRoduct Form");
	product.setStatus("Active");
	String filePathString=session.getServletContext().getRealPath("/");
	String fileName=product.getPimage().getOriginalFilename();
	product.setImgName(fileName);
	System.out.println("File Name : "+fileName);
	productDao.addProduct(product);
	try{
	byte[] imageBytes=product.getPimage().getBytes();
	BufferedOutputStream bos=new BufferedOutputStream(
	new FileOutputStream(filePathString+"/resources/images/"+fileName));
	bos.write(imageBytes);
	bos.close();
	System.out.println(filePathString);
	}
	catch(Exception e){
	e.printStackTrace();
	}

	if(true){
	map.addAttribute("msg", "Product Added Succesfully");
	return "ProductPage";
	}
	else
	{
	map.addAttribute("msg", "Problem in Adding Product . Try Again ");
	return "Add Product";
	}
	}	
	
	 
	/*viewProduct*/
	@RequestMapping(value="/admin/viewAllProducts",method=RequestMethod.GET)
	public String listProduct(ModelMap map){
		List<Product> pros=productDao.listProduct();
		map.addAttribute("productList", pros);
		for(Product pros1:pros) {
		System.out.println(pros1.getProductName()+pros1.getimgName());
		}
		return "viewAll";
        }
	


@RequestMapping(value="/admin/deleteProduct/{productId}",method=RequestMethod.GET)
public ModelAndView deleteProduct(@PathVariable("productId")int pId){
	
	ModelAndView mv=new ModelAndView("viewAll");
	
	productDao.deleteProduct(pId);
	
	List<Product> products=productDao.listProduct();
	mv.addObject("productlist", products);
	
	mv.addObject("msg", "Product Deleted Succesfully");
	return mv;
	
}
@RequestMapping(value="fetchProduct/{proId}",method=RequestMethod.GET)
public ModelAndView fetchProduct(@PathVariable("proId")int pId){
	
	ModelAndView mv=new ModelAndView("AddProduct");
	List<Category> category=categoryDao.list();
	List<Supplier> supplier=supplierDao.listSupplier();
	
	
	Product pObj=productDao.getProductById(pId);
	mv.addObject("productObj", pObj);
	
	mv.addObject("categorylist",category);
	mv.addObject("supplierlist", supplier);
	
	System.out.println("Product Id : "+pObj.getProductId());
	return mv;
	
}
}



 