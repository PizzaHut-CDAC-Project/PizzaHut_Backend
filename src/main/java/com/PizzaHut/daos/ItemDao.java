package com.PizzaHut.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.PizzaHut.entities.Item;

public interface ItemDao extends JpaRepository<Item, Integer> {

	@Query(value="SELECT * from item WHERE type like '%veg'",nativeQuery = true)
	List<Item> findAllPizza();

	List<Item> findByType(String type);

}
