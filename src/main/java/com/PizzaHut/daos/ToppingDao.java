package com.PizzaHut.daos;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.PizzaHut.entities.Topping;


public interface ToppingDao extends JpaRepository<Topping, Integer>{
	Optional<Topping> findByToppingId(int id);
	@Query(value="update toppings set price =:price, toppingName =:toppingName  where toppingId =:toppingId",nativeQuery = true)
	void updateToppingById(Double price, String toppingName, Integer toppingId); 
	

}
