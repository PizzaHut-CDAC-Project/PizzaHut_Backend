package com.PizzaHut.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PizzaHut.entities.Payment;

public interface PaymentDao extends JpaRepository<Payment, Integer>{

}
