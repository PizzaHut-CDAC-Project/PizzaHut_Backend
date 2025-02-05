package com.PizzaHut.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PizzaHut.daos.ToppingDao;
import com.PizzaHut.entities.Topping;

@Service
@Transactional
public class ToppingService {

	@Autowired
	private ToppingDao toppingDao;

	public List<Topping> findAllToppings() {
		return toppingDao.findAll();
	}

	
}
