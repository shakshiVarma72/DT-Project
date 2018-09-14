package com.onlineshop.BackEnd2.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.BackEnd2.dto.Category;

@Repository("categorydao")
@Transactional
public class CategoryDaoImpl implements CategoryDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
   public boolean addCategory(Category Category) {
		try {
		
			System.out.println("I m in addCategory method");
			Session session=sessionFactory.getCurrentSession();
			System.out.println(session+" "+sessionFactory);
			session.save(Category);
			
			return true;
		}
		catch(Exception e)
		{  
			e.printStackTrace();
			return false;}
			
		}
	

	public boolean deleteCategory(Category Category) {
		try {
			sessionFactory.getCurrentSession().delete(Category);
					return true ;
		}
		catch(Exception e)
		{
			return false;
		}
		} 

	public boolean updateCategory(Category Category) {
		try {
			sessionFactory.getCurrentSession().update(Category);
			return true;
}
		catch(Exception e) {
			return false;

		}
	}

	public List<Category> list() {
	Session session =sessionFactory.getCurrentSession();
	Criteria sakshi=session.createCriteria(Category.class);
	List<Category> catList=sakshi.list();
		return catList;
		
	}

	public Category getCategory(int CategoryId) {
		Session session =sessionFactory.openSession();
		Category Category =(Category)session.get(Category.class, CategoryId);
		session.close();

		return Category;
	}

	}
