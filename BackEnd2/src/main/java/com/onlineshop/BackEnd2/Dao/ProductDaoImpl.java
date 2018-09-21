 package com.onlineshop.BackEnd2.Dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Query;
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
		product.setStatus("Deactive");
		session.update(product);
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
		Query query=session.createQuery("from com.onlineshop.BackEnd2.dto.Product ehere Status='Active'");
		List<Product> product=c.list();
		return product;
	}

	
	

	public Product getProductById(int ProductId) {
		Session session =sessionFactory.openSession();
		Product product =(Product)session.get(Product.class, ProductId);
		session.close();

		return product;
	}

	public boolean insertProduct(Product product) {
		
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		}
		catch(Exception e){
			System.out.println(e);
			return false;
			
		}
	}

	public List<Product> getProductsByCategory(int category) {
		System.out.println("Category Id"+category);
		@SuppressWarnings("unchecked")
		Query query=sessionFactory.getCurrentSession().createQuery
		("from com.onlineshop.BackEnd2.dto.Product where category.categoryId=:a");
		query.setParameter("a",category);
		List<Product> list=query.list();
		System.out.println("List of Products : "+list);
		return list;
	}

	/*public List<Product> getProducts() {
		@SuppressWarnings("unchecked")
		TypedQuery<Product> query=getSession().createQuery("from com.onlineshop.BackEnd2.dto.Product where status='Active'");
		List<Product> list=query.getResultList();
		System.out.println("List of Products : "+list);
		return list;
	}*/

	

	/*
	public int getQuantity(int productId) {
		@SuppressWarnings("unchecked")
		TypedQuery<Product> query=getSession().createQuery("from com.niit.backend.dto.Product where productId=:a");
		query.setParameter("a",productId);
		List<Product> list=query.getResultList();
		return list.get(0).getQuantity();
	}

	public void updateQuantity(int productId, int newQuantity) {
		@SuppressWarnings("unchecked")
		TypedQuery<Product> query=getSession().createQuery("update com.niit.backend.dto.Product set quantity=quantity-:b where productId=:a");
		query.setParameter("b",newQuantity);
		query.setParameter("a",productId);
		query.executeUpdate();
				
	}
*/
		}


