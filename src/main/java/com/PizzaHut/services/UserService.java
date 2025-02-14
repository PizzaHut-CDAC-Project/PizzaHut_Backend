package com.PizzaHut.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PizzaHut.dao.UserDao;
import com.PizzaHut.dto.CredentialsDto;
import com.PizzaHut.dto.DtoEntityConvertor;
import com.PizzaHut.dto.UserDto;
import com.PizzaHut.entities.Users;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private DtoEntityConvertor convertor;
	@Autowired
	private PasswordEncoder encoder;

	// to check user by email
	public Users searchByEmail(String email) {
		Users emailCheck = userDao.findByEmail(email);
		if (emailCheck == null)
			return null;
		else
			return emailCheck;
	}
	
	
	public List<Users> getAllUsers(){
		List<Users> list = userDao.findAll();
		if(list!=null) {
			return list;
		}
		else {
			return null;
		}
	}

	// to check user by mobile
	public Users searchByPhone(String phNumber) {
		Users phCheck = userDao.findByPhoneNo(phNumber);
		if (phCheck == null)
			return null;
		else
			return phCheck;
	}

	// to add user
	public Users addUser(Users user) {
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userDao.save(user);
		return user;
	}

	// to get user for sign in
	public Users getUser(CredentialsDto cred) {
		Users signinUser = userDao.findByEmail(cred.getEmail());
		String rawPasword = cred.getPassword();
		if (signinUser != null && encoder.matches(rawPasword, signinUser.getPassword()) && signinUser.getRole().equals("User")) {
			return signinUser;
		} else
			return null;
	}
	public Users getAdmin(CredentialsDto cred) {
		Users signinUser = userDao.findByEmail(cred.getEmail());
		String rawPasword = cred.getPassword();
		if (signinUser != null && encoder.matches(rawPasword, signinUser.getPassword()) && signinUser.getRole().equals("Admin")) {
			return signinUser;
		} else
			return null;
	}

	// update user
	public Users editUsers(int userId, UserDto editUsers) {
		Users checkId = userDao.getById(userId);
		if (checkId != null) {
			Users updateUsers = convertor.toUserEntity(editUsers);
			updateUsers.setUserId(checkId.getUserId());
			updateUsers.setPassword(checkId.getPassword());
			userDao.save(updateUsers);
			return updateUsers;
		}
		return null;
	}
}
