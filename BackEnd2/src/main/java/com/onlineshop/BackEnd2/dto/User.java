 package com.onlineshop.BackEnd2.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity 
@Table(name="User_Tab")
public class User {
	
	@Id
	@NotEmpty(message="Email is mandatory")
	@Email(message="Email should be in correct format")
	private String email;
	
	
	@NotEmpty(message="username is mandatory")
	private String name;
	
	@NotEmpty(message="password is mandatory")
	private String password;
	
	@NotEmpty(message="confirm password is mandatory")
	private String password2;
	
	@Pattern(regexp="(^$|[0-9]{10})")
	@Size(min=10,max=10,message="Phone number must be 10 digit")
	private String phone;
	private String role;
	private boolean enabled;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="user")
	private Set<Address> addresses=new HashSet<Address>();
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	
	
}
