package com.onlineshop.BackEnd2.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.BackEnd2.dto.Order;


@Repository("orderDao")
@Transactional
public class OrderDaoImpl implements OrderDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	public int makeOrder(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}

	

		
}
