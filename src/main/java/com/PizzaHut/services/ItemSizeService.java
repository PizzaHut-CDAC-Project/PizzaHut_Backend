package com.PizzaHut.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PizzaHut.daos.ItemDao;
import com.PizzaHut.daos.ItemSizeDao;
import com.PizzaHut.dtos.ItemSizeDto;
import com.PizzaHut.entities.ItemSize;
import com.app.custom_exceptions.ResourceNotFoundException;

@Service
@Transactional
public class ItemSizeService {

	@Autowired
	private ItemSizeDao itemSizeDao;
	@Autowired
	private ItemDao itemDao;

	// show by sizeId
	public List<ItemSize> SizeOfPizza(int itemId) {
		List<ItemSize> thisSize = itemSizeDao.getSizeOfPizza(itemId);
		return thisSize;
	}

	public ItemSize addItemSize(ItemSizeDto itemSizeDto) {
		ItemSize itemSize = new ItemSize();
		itemSize.setItem(itemDao.findById(itemSizeDto.getItemId()).orElseThrow(
				() -> new ResourceNotFoundException("item with " + itemSizeDto.getItemId() + " not available")));
		itemSize.setPrice(itemSizeDto.getPrice());
		itemSize.setSize(itemSizeDto.getSize());
		itemSizeDao.save(itemSize);
		return itemSize;
	}
}
