package com.onlineshop.BackEnd2.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Supplier {
	
@Id	

private int SupplierId;

private String SupplierName;
private String Address;
private boolean active;


@OneToMany(fetch=FetchType.LAZY,mappedBy="supplier")
Set<Product> product=new HashSet<Product>();


public int getSupplierId() {
	return SupplierId;
}
public Set<Product> getProduct() {
	return product;
}
public void setProduct(Set<Product> product) {
	this.product = product;
}
public void setSupplierId(int supplierId) {
	SupplierId = supplierId;
}
public String getSupplierName() {
	return SupplierName;
}
public void setSupplierName(String supplierName) {
	SupplierName = supplierName;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public boolean isActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
}
	

}
