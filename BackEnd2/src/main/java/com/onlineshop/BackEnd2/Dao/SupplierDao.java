package com.onlineshop.BackEnd2.Dao;

import java.util.List;

import com.onlineshop.BackEnd2.dto.Supplier;

public interface SupplierDao {

	
	public boolean addSupplier(Supplier supplier);
	 public boolean deleteSupplier(int supplierId);
	 public boolean updateSupplier(Supplier supplier);
	public  Supplier  getSupplierById(int sipplierId);
	public List<Supplier> listSupplier();
	

}
