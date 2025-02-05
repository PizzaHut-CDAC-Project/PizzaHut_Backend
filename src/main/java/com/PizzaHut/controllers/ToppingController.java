 package com.PizzaHut.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PizzaHut.entities.Topping;
import com.PizzaHut.services.ToppingService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/toppings")
public class ToppingController {

	@Autowired
	private ToppingService toppingsService;

	//get all toppings	
	@GetMapping("/showAll")
	public ResponseEntity<?> findAllToppings() {
		try {
			List<Topping> checkTopping = toppingsService.findAllToppings();
			if (checkTopping == null)
				return Response.error("Empty");
			return Response.success(checkTopping);
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}
	
	@PostMapping("/addTopping")
	public ResponseEntity<?> addTopping(@RequestBody Topping topping){
		try {
		Topping top=toppingsService.addTopping(topping);
		System.out.println();
		if(top!=null) {
			return Response.success(top);
		}
		return Response.error("failed to add topping");
		}catch(Exception e) {
			return Response.error(e.getMessage());
		}
		
	}

	
	

}
