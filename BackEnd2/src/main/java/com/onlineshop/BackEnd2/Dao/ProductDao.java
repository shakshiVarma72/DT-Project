package com.onlineshop.BackEnd2.Dao;

import java.util.List;
import java.util.Set;

import com.onlineshop.BackEnd2.dto.Product;

public interface ProductDao {
	
	public boolean addProduct(Product product);
	public boolean deleteProduct(int ProductId);
	public boolean updateProduct(Product product);
	public List<Product> listProduct();
	 public Product getProduct(int ProductId);


}
