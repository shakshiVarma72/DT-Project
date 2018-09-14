package com.onlineshop.BackEnd2.Dao;

import java.util.List;

import com.onlineshop.BackEnd2.dto.Address;
import com.onlineshop.BackEnd2.dto.User;

public interface UserDao {
	 
 public User getUserByEmail(String email);
 public User getUserById(int Id);
public Boolean addUser(User user);
public Boolean addAddress(Address  address);
public Address getAddress(int addressId);
 public boolean UpdateAddress(Address address);
public boolean deleteAddress(int UserId);

List<Address> getAllAddress(int UserId);

	

}
