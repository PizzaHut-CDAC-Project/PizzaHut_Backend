package com.PizzaHut.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PizzaHut.entities.User;
import com.PizzaHut.services.UserService;

@CrossOrigin(origins = "*")
@RequestMapping("/user")
@RestController
public class UserController {
	@Autowired
	private UserService Userervice;
	
	@GetMapping("/{email}")
	public ResponseEntity<?> findById(@PathVariable("email") String email) {
		try {
			User result = Userervice.searchByEmail(email);
			if (result == null)
				return Response.error("Not found");
			return Response.success(result);
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}



}
