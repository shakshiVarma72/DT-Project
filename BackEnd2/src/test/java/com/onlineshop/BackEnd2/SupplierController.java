package com.onlineshop.BackEnd2;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlineshop.BackEnd2.Dao.SupplierDao;
import com.onlineshop.BackEnd2.dto.Category;
import com.onlineshop.BackEnd2.dto.Supplier;

public class SupplierController {
static SupplierDao supplierDao;
	
	@BeforeClass
	public static void init() {
		System.out.println("I m here");
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		 context.scan("com.onlineshop.BackEnd2");
		 context.refresh();
		 supplierDao =context.getBean("supplierDao",SupplierDao.class);
	}
	@Test
	@Ignore
public void addSuppliertest() {
		/*Supplier supplier=new Supplier(); 
		supplier.setSupplierName("Fashion Textile");
		supplier.setSupplierAddress("Surat");
		assertTrue("problem in adding supplier",supplierDao.addSupplier(supplier));
		}*/
	
	/*Supplier supplier1=new Supplier(); 
	supplier1.setSupplierName("kids Care Products  ");
	supplier1.setSupplierAddress("Delhi");
	assertTrue("sucessfull adding supplier",supplierDao.addSupplier(supplier1));
	}*/
		
	Supplier supplier2=new Supplier(); 
	supplier2.setSupplierName("India Designs Exports pvt.Ltd ");
	supplier2.setSupplierAddress("Banglore");
	assertTrue("Problem in adding Supplier",supplierDao.addSupplier(supplier2));
	}
	
	@Test
	public void SupplierList(){
		List<Supplier> supplier=supplierDao.listSupplier();
		System.out.println(supplier.size());
		System.out.println("I AM LIST");
		for(Supplier list:supplier) {
			System.out.println(list.getSupplierName()+""   +list.getSupplierAddress());
			
		}
		}
}
