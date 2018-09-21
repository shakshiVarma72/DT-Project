	package com.onlineshop.BackEnd2;
	
	import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
	import org.junit.Ignore;
	import org.junit.Test;
	import org.springframework.context.annotation.AnnotationConfigApplicationContext;
	
	import com.onlineshop.BackEnd2.Dao.ProductDao;
	import com.onlineshop.BackEnd2.dto.Address;
	import com.onlineshop.BackEnd2.dto.Category;
	import com.onlineshop.BackEnd2.dto.Product;
	import com.onlineshop.BackEnd2.dto.Supplier;
	
	public class ProductTest {
	static ProductDao productdao ;
	
	
	@BeforeClass
	public static void init() {
	System.out.println("I m here");
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.onlineshop.BackEnd2");
	context.refresh();
	productdao =context.getBean("productDao",ProductDao.class);
	
	}
	@Test
	@Ignore
	public void addProductTest() {
		
		/*Product pro1=new Product();
		pro1.setProductName(" RADO Watches");
		pro1.setProductDesc("Watches that focus on quality with a specific attention and Detail....");
	    pro1.setQuantity(25);
	    pro1.setPrice(95000);*/
	    
	   /* Product pro2=new Product();
		pro2.setProductName(" Sunglasses");
		pro2.setProductDesc("Sunglasses that focus on quality with a specific attention and Detail....");
	    pro2.setQuantity(20);
	    pro2.setPrice(5000);*/
	    
	    Product pro3=new Product();
		pro3.setProductName(" Hand Bags");
		pro3.setProductDesc("Bags that focus on quality with a specific attention and Detail....");
	    pro3.setQuantity(15);
	    pro3.setPrice(25000);
	    
	   
	    Category cat1=new  Category();
	    cat1.setCategoryName("Accessories");
	    
	    pro3.setCategory(cat1);
	    cat1.getProduct().add(pro3);
	    
	    assertTrue("User added Succesfully" ,productdao.addProduct(pro3));
	
	}
	
	@Test
	@Ignore
	public void updateProduct() {
		Product pro=productdao.getProductById(1);
		
		pro.setProductName("abcd");
		//pro.setProductDesc("xyz");
		//pro.setQuantity(100);
		//pro.setPrice(1500);
		
		
		assertTrue("Update Succesfully",productdao.updateProduct(pro));
		
		
	}
	@Test
	@Ignore
	public void deleteProductById() {
		
		productdao.deleteProduct(1);
		Product product=productdao.getProductById(1);
		assertNull("Product deleted ",product);
		
		
	}
	
	
	@Test
	@Ignore
	public void getAllProducts() {
		System.out.println("I m here in this test case");
		List<Product> products=productdao.listProduct();
		System.out.println(products.size());
		for(Product p:products) {
			System.out.println(p.getProductId()+" "+p.getProductName()+" "+p.getPrice()+" "+p.getProductDesc());
		}
	}
	
	}




