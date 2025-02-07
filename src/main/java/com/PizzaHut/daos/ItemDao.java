package com.PizzaHut.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PizzaHut.entities.Item;

public interface ItemDao extends JpaRepository<Item, Integer> {

	List<Item> findAllPizza();

	List<Item> findByType(String type);
	
//	Optional<Item> findByItemid(int id);

}
