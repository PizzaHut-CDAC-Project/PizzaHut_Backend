package com.PizzaHut.services;

import java.util.ArrayList;
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
	public Topping addTopping(Topping topping) {
		return toppingDao.save(topping);
	}
	public List<Topping> findByToppingId(int toppingId) {
		Topping toppings = toppingDao.getById(toppingId);
		List<Topping> toppingList = new ArrayList<Topping>();
		toppingList.add(toppings);
		return toppingList;
	}
	public void updateTopping(Double price, String toppingName, Integer toppingId) {
		 toppingDao.updateToppingById(price,toppingName,toppingId);

	}
}
