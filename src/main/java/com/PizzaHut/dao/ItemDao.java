package com.PizzaHut.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.PizzaHut.entities.Item;

public interface ItemDao extends JpaRepository<Item, Integer>{
	List<Item> findByType(String type);
	@Query(value="SELECT * from item WHERE type like '%veg'",nativeQuery = true)
	List<Item> findAllPizza();
	Optional<Item> findByItemid(int id);
}
