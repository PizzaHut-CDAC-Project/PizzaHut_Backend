package com.PizzaHut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PizzaHut.dto.ItemSizeDto;
import com.PizzaHut.entities.ItemSize;
import com.PizzaHut.services.ItemSizeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/itemSize")
public class ItemSizeController {
	@Autowired
	private ItemSizeService itemSizeService;
	
	// show itemSize by itemId
	@GetMapping("/{itemid}")
	public ResponseEntity<?> fetchByItemSizeId(@PathVariable("itemid") int itemId) {
		try {
			List<ItemSize> sizeOfPizza = itemSizeService.SizeOfPizza(itemId);
			if(!sizeOfPizza.isEmpty()) {
				return Response.success(sizeOfPizza);
			}else {
				return Response.error("This pizaa is not available in this Size");
			}
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}
	
	@PostMapping("/addItemSize")
	public ResponseEntity<?> addPizzaSize(@RequestBody ItemSizeDto itemSizeDto){
		System.out.println(itemSizeDto);
		ItemSize itemSize=itemSizeService.addItemSize(itemSizeDto);
		if(itemSize.getItem() != null) {
			return Response.success("pizza size inserted successfully");
		}
		else {
			return Response.error("Failed to insert this pizza size");
		}
		
	}
	
}
