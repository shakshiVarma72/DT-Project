package com.onlineshop.BackEnd2.Dao;

import java.util.List;

import com.onlineshop.BackEnd2.dto.Product;

public interface ProductDao {
	
	public boolean addProduct(Product product);
	public boolean deleteProduct(int ProductId);
	public boolean updateProduct(Product pro);
	public List<Product> listProduct();
	 public Product getProductById( int ProductId);
	 public List<Product> getProductsByCategory(int category);

}
