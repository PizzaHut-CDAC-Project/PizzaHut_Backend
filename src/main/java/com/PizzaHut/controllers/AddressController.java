package com.PizzaHut.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	
	//Update address
		@PutMapping("/updateAddress/{AddressId}")
		public ResponseEntity<?> updateAddress(@PathVariable("AddressId")int addId, @RequestBody AddressDto addressdto){
			try {
				System.out.println(addressdto);
				Address newAddress = addressService.updateAddress(addId, addressdto);
				if(newAddress != null) {
					return Response.success("Address added");
				}else {
					return Response.error("Error");
				}
			}catch (Exception e) {
				return Response.error(e.getMessage());
			}
		}
		
		
		//get all address of a user 
		@GetMapping("/getaddress/{userId}")
		public ResponseEntity<?> getAddress(@PathVariable("userId") int userid ){
			try {
				List<Address> allAddresses = addressService.getAddresses(userid);
				if(!allAddresses.isEmpty()) {
					return Response.success(allAddresses);
				}else {
					return Response.error("Please add your address");
				}
			} catch (Exception e) {
				return Response.error(e.getMessage());
			}	
		}
		
		@DeleteMapping("/deleteByAddressId/{addressId}")
		public ResponseEntity<?> deleteAddress(@PathVariable ("addressId")int addressId)
		{
			int count=addressService.deleteByAddressId(addressId);
			if(count==1) {
				return Response.success("Deleted");
			}else {
				return Response.error("id not found");
			}
		}
	
	
	
	
	
	
}








