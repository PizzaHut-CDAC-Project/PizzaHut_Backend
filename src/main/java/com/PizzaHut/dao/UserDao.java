package com.PizzaHut.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PizzaHut.entities.Users;

public interface UserDao extends JpaRepository<Users, Integer> {
	Users findByEmail(String email);
	Users findByPhoneNo(String phoneNo);
}
