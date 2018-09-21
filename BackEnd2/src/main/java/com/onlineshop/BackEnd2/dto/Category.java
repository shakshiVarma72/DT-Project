package com.onlineshop.BackEnd2.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table
public class Category {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	/*@Column(name="C_Id")*/
	private int categoryId;
	
private String categoryName;
private  String categoryDesc;

@OneToMany(fetch=FetchType.EAGER,mappedBy="category",cascade=CascadeType.ALL)
private Set<Product> product=new HashSet<Product>();

public Set<Product> getProduct() {
	return product;
}
public void setProduct(Set<Product> product) {
	this.product = product;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public String getCategoryDesc() {
	return categoryDesc;
}
public void setCategoryDesc(String categoryDesc) {
	this.categoryDesc = categoryDesc;
}
public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}




}
