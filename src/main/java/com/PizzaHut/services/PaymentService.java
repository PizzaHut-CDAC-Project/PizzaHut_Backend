package com.PizzaHut.services;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PizzaHut.dao.AddressDao;
import com.PizzaHut.dao.CartDao;
import com.PizzaHut.dao.PaymentDao;
import com.PizzaHut.dao.UserDao;
import com.PizzaHut.dto.DtoEntityConvertor;
import com.PizzaHut.dto.PaymentDto;
import com.PizzaHut.entities.Payments;
import com.PizzaHut.entities.Users;
import com.app.custom_exceptions.ResourceNotFoundException;

@Service
@Transactional
public class PaymentService {
	@Autowired
	private DtoEntityConvertor convertor;
	@Autowired
	private PaymentDao paymentDao;	
	@Autowired
	private CartDao cartDao;
	@Autowired UserDao userDao;
	
	public Payments addPayments(PaymentDto paymentDto)
	{
		Double totalAmount = cartDao.findTotalAmount(paymentDto.getUserId());
		
//		paymentDto.setMode("Card Payment");
//		paymentDto.setPayStatus("success");
		System.out.println(totalAmount);
		if(totalAmount != 0) {
			Payments add= new Payments();
			Users user= userDao.findById(paymentDto.getUserId()).orElseThrow(()-> new ResourceNotFoundException("invalid user id"));
			add.setUsers(user);
			add.setMode("Card Payment");
			add.setPayStatus("success");
			add.setTotalAmount(totalAmount);
//			Payments add=convertor.toPaymentEntity(paymentDto,totalAmount);
			System.out.println(add);
			paymentDao.save(add);
			return add;
		}
		throw new ResourceNotFoundException("total amount is zero");
	}
	
	public Payments findPayments(int payId)
	{
		Payments togetPayments=paymentDao.getById(payId);
		return togetPayments;
		
	}
}
