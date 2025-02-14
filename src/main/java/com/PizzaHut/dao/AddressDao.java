package com.PizzaHut.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PizzaHut.entities.Address;
import com.PizzaHut.entities.Users;

public interface AddressDao extends JpaRepository<Address, Integer> {
	List<Address> findByUser(Users user);
}