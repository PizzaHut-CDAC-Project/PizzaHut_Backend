package com.PizzaHut.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.PizzaHut.daos.ItemDao;
import com.PizzaHut.dtos.ItemDto;
import com.PizzaHut.entities.Item;

public class ItemService {

	@Autowired
	private ItemDao itemDao;

	public Item addPizza(ItemDto pizzaDto) {
		ModelMapper mapper = new ModelMapper();
		Item pizza = new Item();
		mapper.map(pizzaDto, pizza);
		itemDao.save(pizza);

		return pizza;
	}

	// show all items in the list
	public List<Item> findAllItem() {
		return itemDao.findAllPizza();
	}

}
