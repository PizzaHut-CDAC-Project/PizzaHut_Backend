package com.PizzaHut.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PizzaHut.entities.ToppingImages;

public interface ToppingImageDao extends JpaRepository<ToppingImages,Integer>{

	ToppingImages findByToppingImgId(int toppingImgId);
}
