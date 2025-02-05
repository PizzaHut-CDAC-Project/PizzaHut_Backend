package com.PizzaHut.daos;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PizzaHut.entities.Topping;


public interface ToppingDao extends JpaRepository<Topping, Integer>{
	Optional<Topping> findByToppingId(int id);
}
