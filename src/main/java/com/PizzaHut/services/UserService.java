package com.PizzaHut.services;




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

	
	@Autowired
	private PasswordEncoder encoder;

	// to check user by email
	public User searchByEmail(String email) {
		User emailCheck = userDao.findByEmail(email);
		if (emailCheck == null)
			return null;
		else
			return emailCheck;
	}


	// to check user by mobile
		public User searchByPhone(String phNumber) {
			User phCheck = userDao.findByPhoneNo(phNumber);
			if (phCheck == null)
				return null;
			else
				return phCheck;
		}


		// to add user
		public User addUser(User user) {
			String encodedPassword = encoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			userDao.save(user);
			return user;
		}
}
