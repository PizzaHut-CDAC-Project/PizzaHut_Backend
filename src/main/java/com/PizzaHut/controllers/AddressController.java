package com.PizzaHut.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PizzaHut.dtos.AddressDto;
import com.PizzaHut.entities.Address;
import com.PizzaHut.services.AddressService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	//get address by id
	@GetMapping("/getaddressbyid/{AddressId}")
	public ResponseEntity<?> getAddressById(@PathVariable("AddressId") int AddressId){
		try {
			Address AddresseById = addressService.getAddressById(AddressId);
			if(AddresseById != null) {
				return Response.success(AddresseById);
			}else {
				return Response.error("Address not found");
			}
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}	
	}
	
	
	//add new address of a particular user
	@PostMapping("/addAddress")
	public ResponseEntity<?> addAddress(@RequestBody AddressDto addressdto){
		try {
			Address addAddress = addressService.addAddress(addressdto);
			return Response.success(addAddress);
		}
		catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}
	
}








