package com.PizzaHut.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PizzaHut.entities.ToppingImage;

public interface ToppingImageDao extends JpaRepository<ToppingImage,Integer>{
	ToppingImage findByToppingImgId(int toppingImgId);

}
