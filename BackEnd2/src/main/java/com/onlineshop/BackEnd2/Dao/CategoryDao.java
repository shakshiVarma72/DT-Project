package com.onlineshop.BackEnd2.Dao;

import java.util.List;

import com.onlineshop.BackEnd2.dto.Category;

public interface CategoryDao {
		public boolean addCategory(Category category);
		public boolean deleteCategory(int categoryId );
		public boolean updateCategory(Category category);
		public List<Category> list();
		 public Category getCategory(int CategoryId);
		 
	}



