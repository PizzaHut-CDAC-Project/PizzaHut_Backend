package com.PizzaHut.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PizzaHut.daos.AddressDao;
import com.PizzaHut.entities.Address;



@Service
@Transactional
public class AddressService {
	@Autowired
	private AddressDao addressDao;

	
	
	//findByAddressId
	public Address getAddressById(int id) {
		System.out.println("In service");
		Address getAddressById = addressDao.getById(id);
		 if(getAddressById != null) {
			 return getAddressById;
		 }
		 return null;
	}
	
	
}







