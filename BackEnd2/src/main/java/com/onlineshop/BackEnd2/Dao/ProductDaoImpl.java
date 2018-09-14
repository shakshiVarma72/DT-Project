 package com.onlineshop.BackEnd2.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.BackEnd2.dto.Product;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {

@Autowired
SessionFactory sessionFactory;


	public boolean addProduct(Product product) {
    try {
			
       Session session=sessionFactory.getCurrentSession();
		session.save(product);
			
			return true;
		}
		catch(Exception e) 
		{  
			e.printStackTrace();
			
		
		return false;
	}}

	public boolean deleteProduct(int productId) {
		Session session=sessionFactory.getCurrentSession();
		Product product=(Product)session.get(Product.class,productId );
	if(product!=null) {
			System.out.println("Record Deleted");
			session.delete(product);
		}
		else {
			System.out.println("Record Not found");
		}
   return true;
	}

	
	public boolean updateProduct(Product product) {
try {
			
			Session session=sessionFactory.getCurrentSession();
			session.save(product);
			
			return true;
		}
		catch(Exception e)
		{  
			e.printStackTrace();
			return false;}
		
	}

	public List<Product> listProduct() {
		
		Session session =sessionFactory.openSession();
		Criteria c=session.createCriteria(Product.class);
		@SuppressWarnings("unchecked")
		List<Product> product=c.list();
		return product;
	}

	
	

	public Product getProduct(int Product) {
		Session session =sessionFactory.openSession();
		Product product =(Product)session.get(Product.class, Product);
		session.close();

		return product;
	}

	
	

	
		
	}


