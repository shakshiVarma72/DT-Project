package com.onlineshop.BackEnd2.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.BackEnd2.dto.Supplier;

@Repository("supplierDao")
@Transactional
public class SupplierDaoImpl implements SupplierDao {
	
	@Autowired
	SessionFactory sessionFactory;
public boolean addSupplier(Supplier supplier) {
		try {
			Session session=sessionFactory.getCurrentSession();
				session.save(supplier);
				 
					return true;
				}
				catch(Exception e) 
				{  
					e.printStackTrace();
					return false;
	}}

   public boolean deleteSupplier(int supplierId) {
		Session session=sessionFactory.getCurrentSession();
		Supplier supplier=(Supplier)session.get(Supplier.class,supplierId );
	     if(supplier!=null) {
	     System.out.println("Record Deleted");
			session.delete(supplier);
		}
		else {
			System.out.println("Record Not found");
		}
   return true;	
	}
   

	public boolean updateSupplier(Supplier supplier) {
	    try {
			Session session=sessionFactory.getCurrentSession();
			session.save(supplier);
			return true;
		}
		catch(Exception e)
		{  
			e.printStackTrace();
			return false;}}

	public Supplier getSupplierById(int supplierId) {
		Session session=sessionFactory.getCurrentSession();
		Supplier byid=(Supplier)session.get(Supplier.class, supplierId);
         return byid;

	}

	
	public List<Supplier> listSupplier() {
		Session session =sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Supplier.class);
		@SuppressWarnings("unchecked")
		List<Supplier> supplier=c.list();
		return supplier;	}

}
