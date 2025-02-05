package com.PizzaHut.controllers;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PizzaHut.entities.User;
import com.PizzaHut.services.UserService;

@CrossOrigin(origins = "*")
@RequestMapping("/user")
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/{email}")
	public ResponseEntity<?> findById(@PathVariable("email") String email) {
		try {
			User result = userService.searchByEmail(email);
			if (result == null)
				return Response.error("Not found");
			return Response.success(result);
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}

	
	
	// API for User sign up 
	@PostMapping("/signup")
	public ResponseEntity<?> SignUpUser(@Valid @RequestBody User user){
		try {
			User newUserEmailVerify=userService.searchByEmail(user.getEmail());
			User newUserPhVerify=userService.searchByPhone(user.getPhoneNo());
			if(newUserEmailVerify==null && newUserPhVerify==null) {
				User add=userService.addUser(user);
				return Response.success(add);
			}else if(newUserEmailVerify !=null) {
				return Response.error("Email already exist");
			}else if(newUserPhVerify != null) {
				return Response.error("Phone Number already exists");
			}else {
				return Response.error("Something went wrong");
			}
			
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}


}
