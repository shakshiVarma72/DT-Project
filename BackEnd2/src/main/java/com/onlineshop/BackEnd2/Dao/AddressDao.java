package com.onlineshop.BackEnd2.Dao;

import com.onlineshop.BackEnd2.dto.Address;

public interface AddressDao {

	public void insertAddress(Address address);
	public Address getAddressById(int addressId);
	public void updateAddress(Address address);
	public void deleteAddress(int addressId);
}
