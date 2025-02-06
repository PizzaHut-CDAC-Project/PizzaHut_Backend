package com.PizzaHut.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PizzaHut.entities.Item;

public interface ItemDao extends JpaRepository<Item, Integer> {

	List<Item> findAllPizza();

}
