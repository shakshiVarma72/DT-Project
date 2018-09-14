package com.Project.FrontEnd.controllers;


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	
	@RequestMapping(value="/getProductPage",method=RequestMethod.GET)
	public String getProductPage() {
		return "ProductPage"; 
	}
	
	/*add product*/
	@RequestMapping(value="getaddproduct",method=RequestMethod.GET)
	public String getProductForm(ModelMap map){
		System.out.println(" I AM ADD ");
		
		List<Category> categories=categoryDao.list();
	    
		List<Supplier> suppliers=supplierDao .listSupplier();
		
		map .addAttribute("supplierList",suppliers);
		
		 map.addAttribute("categoryList",categories);
		 map.addAttribute("ProForm",new Product());
		 
		 for(Category cat:categories) {
			 System.out.println("I AM LOOP");
				System.out.println("HELLO"+cat.getCategoryName());
			}

		return "ProductForm2";
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

@RequestMapping(value="/addUpdateproduct",method=RequestMethod.POST)
	public String addProduct(HttpServletRequest request, ModelMap map,@RequestParam("file")MultipartFile file){
		
		
		String id=request.getParameter("pId");
		System.out.println("id - "+id);
		
		if(id.equals("")){
		Product p=new Product();
		p.setProductName(request.getParameter("productName"));
		p.setProductDesc(request.getParameter("productDesc"));
		p.setPrice(Double.parseDouble(request.getParameter("productPrice")));
		p.setQuantity(Integer.parseInt(request.getParameter("productQuantity")));
		
		System.out.println("Hello "+request.getParameter("category")+" "+request.getParameter("supplier"));
		
		Category catObj=categoryDao.getCategory(Integer.parseInt(request.getParameter("category")));
		p.setCategory(catObj);
		
		Supplier supp=supplierDao.getSupplierById(Integer.parseInt(request.getParameter("supplier")));
		p.setSupplier(supp);
		
		System.out.println("Category Obj : "+catObj+" "+supp);
		
	
		String filePath=request.getSession().getServletContext().getRealPath("/");
		String fileName=file.getOriginalFilename();
		
		System.out.println("File Name :  "+fileName);
		p.setImgName(fileName);
		boolean r=productDao.addProduct(p);
		
		try {
			byte[] imageBytes=file.getBytes();
			BufferedOutputStream bos=new BufferedOutputStream(
					new FileOutputStream(filePath+"/resources/images/"+fileName));
			bos.write(imageBytes);
			bos.close();
			
			System.out.println(filePath);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		if(r){
			List<Product> products=productDao.listProduct();
			map.addAttribute("productlist", products);
			
			map.addAttribute("msg", "Product Added Succesfully");
			System.out.println("I m here");
			return "viewAll";
		}
		else{
			map.addAttribute("msg", "Problem in Adding Product .Try Again");
			return "AddProduct";
	}
		
	}
		else {
			
			int pId=Integer.parseInt(id);
			
			Product p=new Product();
			p.setProductId(pId);
			p.setProductName(request.getParameter("productName"));
			p.setProductDesc(request.getParameter("productDesc"));
			p.setPrice(Double.parseDouble(request.getParameter("productPrice")));
			p.setQuantity(Integer.parseInt(request.getParameter("productQuantity")));
			
			System.out.println("Hello "+request.getParameter("category")+" "+request.getParameter("supplier"));
			
			Category catObj=categoryDao.getCategory(Integer.parseInt(request.getParameter("category")));
			p.setCategory  (catObj);
			
			Supplier supp=supplierDao.getSupplierById(Integer.parseInt(request.getParameter("supplier")));
			p.setSupplier(supp);
			
			System.out.println("Category Obj : "+catObj+" "+supp);
			
			//p.setStatus("Active");
			
			System.out.println("Uploading the Product");
			
			String filePath=request.getSession().getServletContext().getRealPath("/");
			String fileName=file.getOriginalFilename();
			
			System.out.println(filePath+" "+fileName);
			
			if(fileName.equals("")){
				p.setImgName(productDao.getProduct(pId).getimgName());
			}
			else {
				p.setImgName(fileName);
				try {
					byte[] imageBytes=file.getBytes();
					BufferedOutputStream bos=new BufferedOutputStream(
							new FileOutputStream(filePath+"/resources/images/"+fileName));
					bos.write(imageBytes);
					bos.close();
					
					System.out.println(filePath);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			
			productDao.updateProduct(p);
			List<Product> products=productDao.listProduct();
			map.addAttribute("productlist", products);
			
			map.addAttribute("msg", "Product Updated Succesfully");
			System.out.println("I m here");
			return "viewAll";
		}
		}
	
	
	 
	/*viewProduct*/
	@RequestMapping(value="viewAllProducts",method=RequestMethod.GET)
	public String listProduct(ModelMap map){
		List<Product> pros=productDao.listProduct();
		map.addAttribute("productlist", pros);
		return "viewAll";
        }
	


@RequestMapping(value="deleteProduct/{proId}",method=RequestMethod.GET)
public ModelAndView deleteProduct(@PathVariable("proId")int pId){
	
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
	
	
	Product pObj=productDao.getProduct(pId);
	mv.addObject("productObj", pObj);
	
	mv.addObject("categorylist",category);
	mv.addObject("supplierlist", supplier);
	
	System.out.println("Product Id : "+pObj.getProductId());
	return mv;
	
}
}



 