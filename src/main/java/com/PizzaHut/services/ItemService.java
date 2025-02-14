package com.PizzaHut.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PizzaHut.dao.ItemDao;
import com.PizzaHut.dao.ItemImageDao;
import com.PizzaHut.dao.ItemSizeDao;
import com.PizzaHut.dto.ApiResponse;
import com.PizzaHut.dto.ItemDto;
import com.PizzaHut.entities.Item;
import com.app.custom_exceptions.ResourceNotFoundException;

@Service
@Transactional
public class ItemService {

	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private ItemSizeDao sizeDao;
	
	@Autowired
	private ItemImageDao imageDao;
	public Item addPizza(ItemDto pizzaDto) {
		ModelMapper mapper=new ModelMapper();
			Item pizza= new Item();
			mapper.map(pizzaDto,pizza);
			itemDao.save(pizza);
		
	return pizza;
	}
	
	// show all items in the list
		public List<Item> findAllItem() {
			return itemDao.findAllPizza();
		}

	// show selected item by it's Id
	public Item findByItemId(int itemId) {
		Item item = itemDao.getById(itemId);
		return item;
	}
	
	public List<Item> findByType(String type){
		List<Item> listBytype = itemDao.findByType(type);
		if(listBytype != null) {
			return listBytype;
		}
		return null;
	}

	public String updateItem(Integer itemId, ItemDto itemDto) {
		Item item= itemDao.findById(itemId).orElseThrow(()->new ResourceNotFoundException("No such item exists"));
		item.setDescription(itemDto.getDescription());
		item.setItemName(itemDto.getItemName());
		item.setType(itemDto.getType());
		return "updated successfully";
	}

	public String deleteItem(Integer itemId) {
		
		sizeDao.deleteAllByItemId(itemId);
		imageDao.deleteAllByItemId(itemId);
		itemDao.deleteById(itemId);
		return itemId+" deleted successfully";
	}
}
