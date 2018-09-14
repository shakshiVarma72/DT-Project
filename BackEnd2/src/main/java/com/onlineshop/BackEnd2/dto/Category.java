package com.onlineshop.BackEnd2.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table
public class Category {

	
	@Id
	@GeneratedValue
	/*@Column(name="C_Id")*/
	private int categoryId;
	
private String CategoryName;
private  String CategoryDesc;

@OneToMany(fetch=FetchType.LAZY,mappedBy="category")
private Set<Product> product=new HashSet<Product>();

public Set<Product> getProduct() {
	return product;
}
public void setProduct(Set<Product> product) {
	this.product = product;
}
public String getCategoryName() {
	return CategoryName;
}
public void setCategoryName(String categoryName) {
	CategoryName = categoryName;
}
public String getCategoryDesc() {
	return CategoryDesc;
}
public void setCategoryDesc(String categoryDesc) {
	CategoryDesc = categoryDesc;
}
public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}




}
