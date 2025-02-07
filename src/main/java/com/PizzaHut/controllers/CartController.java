package com.PizzaHut.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PizzaHut.dtos.CartDto;
import com.PizzaHut.dtos.CartDtoWithoutTopping;
import com.PizzaHut.entities.Cart;
import com.PizzaHut.services.CartService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;

	// add to cart with topping
	@PostMapping("/addWithToppings")
	public ResponseEntity<?> addToCart(@RequestBody CartDto cartdto) {
		try {
			System.out.println(cartdto);
			Cart addTocart = cartService.addTocart(cartdto);
			if (addTocart != null) {
				return Response.success(addTocart);
			} else {
				return Response.error("failed to add to cart");
			}
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}
	
	// add without topping
		@PostMapping("/addWithoutToppings")
		public ResponseEntity<?> addToCartNoTopping(@RequestBody CartDtoWithoutTopping cartWithoutTopping) {
			try {
				System.out.println(cartWithoutTopping);
				Cart addTocart = cartService.addTocart(cartWithoutTopping);
				if (addTocart != null) {
					return Response.success(addTocart);
				} else {
					return Response.error("failed to add to cart");
				}
			} catch (Exception e) {
				return Response.error(e.getMessage());
			}
		}
		 
		// Delete Cart by cartId
		@DeleteMapping("/deleteById/{cartId}")
		public ResponseEntity<?> deleteCart(@PathVariable("cartId") int cartId) {
			int count = cartService.deleteByCartId(cartId);
			if (count == 1) {
				return Response.success("Deleted");
			} else
				return Response.error("id not found");
		}
		 

}
