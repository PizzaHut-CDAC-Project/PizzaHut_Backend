package com.PizzaHut.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PizzaHut.entities.Feedback;

public interface FeedBackDao extends JpaRepository<Feedback, Integer>{

   
}