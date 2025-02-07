package com.PizzaHut.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PizzaHut.entities.Address;
import com.PizzaHut.entities.User;

public interface AddressDao extends JpaRepository<Address, Integer> {
	List<Address> findByUser(User user);
}