package com.PizzaHut.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PizzaHut.daos.CartDao;
import com.PizzaHut.dtos.CartDto;
import com.PizzaHut.dtos.DtoEntityConvertor;
import com.PizzaHut.entities.Cart;
import com.PizzaHut.entities.DeliveryStatus;
import com.app.custom_exceptions.ResourceNotFoundException;

@Service
@Transactional
public class CartService {
	@Autowired
	private CartDao cartDao;
	@Autowired
	private DtoEntityConvertor convertor;
 
	// add in cart with topping
		public Cart addTocart(CartDto cartDto) {
			Cart cartAdd = convertor.tocartEntity(cartDto);
			System.out.println("===>>>>===>>>>" + cartAdd);
			cartDao.save(cartAdd);
			return cartAdd;
		}
	
	// add foreignKey
	public String addForeignKey(int delId, int userid) {
		System.out.println("this is payment id" + delId);
		int returned = cartDao.addForeign(delId, userid);
		System.out.println("WE are here===" + returned);
		cartDao.changeStatus(userid);
		return "cart Status updated "+delId+" "+userid;
	}
}
