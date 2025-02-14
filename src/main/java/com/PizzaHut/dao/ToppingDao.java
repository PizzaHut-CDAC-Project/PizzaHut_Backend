package com.PizzaHut.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.PizzaHut.entities.Toppings;


public interface ToppingDao extends JpaRepository<Toppings, Integer>{
	Optional<Toppings> findByToppingId(int id);
	@Modifying
	@Query(value="update toppings set price =:price, toppingName =:toppingName  where toppingId =:toppingId",nativeQuery = true)
	void updateToppingById(Double price, String toppingName, Integer toppingId); 
	
	
	
}
