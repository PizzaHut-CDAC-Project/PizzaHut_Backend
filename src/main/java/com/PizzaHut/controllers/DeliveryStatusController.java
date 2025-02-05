package com.PizzaHut.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PizzaHut.entities.DeliveryStatus;
import com.PizzaHut.services.DeliveryStatusService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/DeliveryStatus")
public class DeliveryStatusController {

	@Autowired
	private DeliveryStatusService statusService;
	// get delivery
	@GetMapping("/{userId}")
	public ResponseEntity<?> viewDeliveryStatus(@PathVariable("userId") int userId) {
		try {
			System.out.println("In delivery controller");
			List<DeliveryStatus> result = statusService.findByUserId(userId);
			System.out.println(result);
			if (result.isEmpty())
				return Response.error("No result found");
			return Response.success(result);
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}
 }

