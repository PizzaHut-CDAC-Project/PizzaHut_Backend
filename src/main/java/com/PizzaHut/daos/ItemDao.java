package com.PizzaHut.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.PizzaHut.entities.Item;
import com.PizzaHut.entities.ToppingImage;

public interface ItemDao extends JpaRepository<Item, Integer> {

	@Query(value="SELECT * from item WHERE type like '%veg'",nativeQuery = true)
	List<Item> findAllPizza();

	List<Item> findByType(String type);
	
	Optional<Item> findByItemid(int id);

}
