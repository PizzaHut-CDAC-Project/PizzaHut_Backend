package com.PizzaHut.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PizzaHut.daos.CartDao;
import com.PizzaHut.daos.PaymentDao;
import com.PizzaHut.daos.UserDao;
import com.PizzaHut.dtos.PaymentDto;
import com.PizzaHut.entities.Payment;
import com.PizzaHut.entities.User;
import com.app.custom_exceptions.ResourceNotFoundException;

@Service
@Transactional
public class PaymentService {

	@Autowired
	private PaymentDao paymentDao;	
	@Autowired
	private CartDao cartDao;
	@Autowired 
	private UserDao userDao;
	
	public Payment addPayments(PaymentDto paymentDto)
	{
		Double totalAmount = cartDao.findTotalAmount(paymentDto.getUserId());
		

		System.out.println(totalAmount);
		if(totalAmount != 0) {
			Payment add= new Payment();
			User user= userDao.findById(paymentDto.getUserId()).orElseThrow(()-> new ResourceNotFoundException("invalid user id"));
			add.setUsers(user);
			add.setMode("Card Payment");
			add.setPayStatus("success");
			add.setTotalAmount(totalAmount);
			System.out.println(add);
			paymentDao.save(add);
			return add;
		}
		throw new ResourceNotFoundException("total amount is zero");
	}
	public Payment findPayments(int payId)
	{
		Payment togetPayments=paymentDao.getById(payId);
		return togetPayments;
		
	}
	
	
}
