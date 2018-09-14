package com.onlineshop.BackEnd2.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.BackEnd2.dto.Address;
import com.onlineshop.BackEnd2.dto.User;


@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	
	
	@Autowired
	SessionFactory sessionFactory;
	
	


	public User getUserByEmail(String email) {
		Session session=sessionFactory.getCurrentSession();
		User bymail=(User)session.get(User.class, email );
		return bymail;
	}

	public User getUserById(int Id) {
		Session session=sessionFactory.getCurrentSession();
		User byid=(User)session.get(User.class, Id);
         return byid;
	}

	public Boolean addUser(User user) {
		try {
	
		Session session=sessionFactory.getCurrentSession();
		session.save(user);
		
		return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return false;}
		
	}


	public Boolean addAddress(Address address) {
		return null;
		
		
	}

	public Address getAddress(int addressId) {
		Session session=sessionFactory.getCurrentSession();
		Address byadd=(Address)session.get(Address.class, addressId);

		return byadd;
	}

	public boolean UpdateAddress(Address address) {
		return false;
	}

	public boolean deleteAddress(int UserId) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class,UserId);

		return false;
	}

	public List<Address> getAllAddress(int UserId) {
		// TODO Auto-generated method stub
		return null;
	}

}
