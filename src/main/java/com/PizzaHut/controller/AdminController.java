package com.PizzaHut.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PizzaHut.dto.CredentialsDto;
import com.PizzaHut.entities.Users;
import com.PizzaHut.services.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/profile")
	public ResponseEntity<?> getAllUsers(){
		System.out.println("in admins getAllUsers method");
		try {
			List<Users> allUsers = userService.getAllUsers();
			if (allUsers != null)
				return Response.success(allUsers);
			return Response.error("Empty");
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
		
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> signInUser(@Valid @RequestBody CredentialsDto cred) {
		Users userSignIn = userService.getAdmin(cred);
		if (userSignIn != null) {
			return Response.success(userSignIn);
		} else {
			return Response.error("Invalid Credentials");
		}
	}
	
}
