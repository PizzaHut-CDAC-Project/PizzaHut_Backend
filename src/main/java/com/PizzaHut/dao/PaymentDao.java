package com.PizzaHut.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PizzaHut.entities.Payments;

public interface PaymentDao extends JpaRepository<Payments, Integer>{

}
