package com.PizzaHut.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PizzaHut.dtos.ItemDto;
import com.PizzaHut.entities.Item;
import com.PizzaHut.services.ItemService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	// to get all items
	@GetMapping("/showAll")
	public ResponseEntity<?> findAllItems() {
		try {
			List<Item> checkItem = itemService.findAllItem();
			if (checkItem != null)
				return Response.success(checkItem);
			return Response.error("Empty");
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}

	@PostMapping("/addpizza")
	public ResponseEntity<?> addPizza(@RequestBody ItemDto pizza) {
		System.out.println("in add pizza");
		return Response.success(itemService.addPizza(pizza));
	}
	
	
	@PutMapping("/updateItem/{itemId}")
	public ResponseEntity<?> updateItem(@PathVariable Integer itemId, @RequestBody ItemDto itemDto){
		try {
			System.out.println("in updateItem/{itemId}");
			String updateStatus=itemService.updateItem(itemId, itemDto);
			if (updateStatus == null)
				return Response.error("No result found");
			return Response.success(updateStatus);
		}catch(Exception e) {
			return Response.error(e.getMessage());
		}
	}

}
