package com.onlineshop.BackEnd2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlineshop.BackEnd2.Dao.CategoryDao;
import com.onlineshop.BackEnd2.Dao.ProductDao;
import com.onlineshop.BackEnd2.dto.Category;
public class CatagoryDaoTest {
	
	static CategoryDao categorydao;
	
	@BeforeClass
	public static void init() {
		System.out.println("I m here");
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		 context.scan("com.onlineshop.BackEnd2");
		 context.refresh();
		 categorydao =context.getBean("categorydao",CategoryDao.class);
			
		 System.out.println("Category dao obj = "+categorydao);
	}
	@Test
	@Ignore
	public void addCategorytest() {
		/*Category category=new Category(); 
		category.setCategoryName("Accessories");
		category.setCategoryDesc("all top brands accessories are here....");
		assertTrue("Problem in adding Category",categorydao.addCategory(category));*/
		
		/*Category category1=new Category();
		category1.setCategoryName("Womens");
		category1.setCategoryDesc("all top brand  Kurti are here....");
		assertTrue("Problem in adding Category",categorydao.addCategory(category1));*/
		
		/*Category category2=new Category();
		category2.setCategoryName("Mens");
		category2.setCategoryDesc("all top brands T-shirts are here....");
		assertTrue("Problem in adding Category",categorydao.addCategory(category2));*/
		
		/*Category category3=new Category();
		category3.setCategoryName("Kids");
		category3.setCategoryDesc("all top baby Products are here....");
		assertTrue("Problem in adding Category",categorydao.addCategory(category3));*/
		
		Category category4=new Category();
		category4.setCategoryName("Home & Living ");
		category4.setCategoryDesc("all Home products are here....");
		assertTrue("Problem in adding Category",categorydao.addCategory(category4));
		
	} 

	@Test
	@Ignore
	public void getCategory() {
		
		Category category=categorydao.getCategory(1);
		System.out.println(category.getCategoryName()+"" +category.getCategoryDesc());
		assertNull("User Not Found",category);
}
	
	
	@Test
	 @Ignore 
	public void productsList(){
		List<Category> batman=categorydao.list();
		System.out.println(batman.size());
		System.out.println("I AM LIST");

		for(Category list:batman) {
			System.out.println(list.getCategoryName()+""+list.getCategoryDesc());
			
		}
		}
	} 
