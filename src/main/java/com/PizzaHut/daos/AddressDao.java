package com.PizzaHut.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PizzaHut.entities.Address;

public interface AddressDao extends JpaRepository<Address, Integer> {

}