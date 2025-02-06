package com.PizzaHut.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
