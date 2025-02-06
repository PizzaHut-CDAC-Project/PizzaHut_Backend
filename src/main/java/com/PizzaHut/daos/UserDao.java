package com.PizzaHut.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PizzaHut.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByEmail(String email);
	User findByPhoneNo(String phoneNo);
}
