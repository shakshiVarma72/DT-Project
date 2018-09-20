package com.onlineshop.BackEnd2.Dao;

import com.onlineshop.BackEnd2.dto.Address;



	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

	
	@Repository("addressDAO")
	@Transactional
	public class AddressDaoImpl implements AddressDao {

		@Autowired
		private SessionFactory sessionFactory;
		
		public Session getSession(){
			return sessionFactory.getCurrentSession();
		}

		public void insertAddress(Address address) {
			getSession().save(address);
			
		}
public Address getAddressById(int addressId) {
			Address addr=(Address)getSession().get(Address.class,addressId);
			return addr;
		}

public void updateAddress(Address address) {
			getSession().update(address);
			
		}

public void deleteAddress(int addressId) {
			Address addr=(Address)getSession().get(Address.class, addressId);
			getSession().delete(addr);
			
		}

	}
