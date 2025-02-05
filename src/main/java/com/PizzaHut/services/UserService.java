package com.PizzaHut.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PizzaHut.daos.UserDao;
import com.PizzaHut.entities.User;



@Service
@Transactional
public class UserService {
	@Autowired
	private UserDao userDao;


	// to check user by email
	public User searchByEmail(String email) {
		User emailCheck = userDao.findByEmail(email);
		if (emailCheck == null)
			return null;
		else
			return emailCheck;
	}
	
}
