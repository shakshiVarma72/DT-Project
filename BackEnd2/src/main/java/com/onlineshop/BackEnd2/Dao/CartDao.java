package com.onlineshop.BackEnd2.Dao;

import com.onlineshop.BackEnd2.dto.Cart;

public interface CartDao {

		boolean addCart(Cart cart);
		Cart getCartByCustomer(String customerId);
		boolean deleteCart(int cartId);
	}


