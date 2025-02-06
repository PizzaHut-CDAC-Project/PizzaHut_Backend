package com.PizzaHut.services;




import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PizzaHut.daos.UserDao;
import com.PizzaHut.dtos.CredentialsDto;
import com.PizzaHut.dtos.DtoEntityConvertor;
import com.PizzaHut.dtos.UserDto;
import com.PizzaHut.entities.User;



@Service
@Transactional
public class UserService {
	@Autowired
	private UserDao userDao;

	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private DtoEntityConvertor convertor;

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


		// to get user for sign in
		public User getUser(CredentialsDto cred) {
			User signinUser = userDao.findByEmail(cred.getEmail());
			String rawPasword = cred.getPassword();
			if (signinUser != null && encoder.matches(rawPasword, signinUser.getPassword()) && signinUser.getRole().equals("User")) {
				return signinUser;
			} else
				return null;
		}


		public User editUsers(int userId, UserDto editUsers) {
			User checkId = userDao.getById(userId);
			if (checkId != null) {
				User updateUsers = convertor.toUserEntity(editUsers);
				updateUsers.setUserId(checkId.getUserId());
				updateUsers.setPassword(checkId.getPassword());
				userDao.save(updateUsers);
				return updateUsers;
			}
			return null;
		}
		
		
}
