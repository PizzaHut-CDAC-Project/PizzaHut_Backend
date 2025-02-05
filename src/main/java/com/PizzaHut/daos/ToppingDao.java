package com.PizzaHut.daos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.PizzaHut.entities.Topping;


public interface ToppingDao extends JpaRepository<Topping, Integer>{

}
