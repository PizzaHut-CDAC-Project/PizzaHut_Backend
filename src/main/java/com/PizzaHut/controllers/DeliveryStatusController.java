package com.PizzaHut.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PizzaHut.dtos.DeliveryDto;
import com.PizzaHut.dtos.DeliveryStatUpdateDto;
import com.PizzaHut.entities.DeliveryStatus;
import com.PizzaHut.services.DeliveryStatusService;
import com.app.custom_exceptions.ResourceNotFoundException;

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
	
	@PostMapping("/add")
	public ResponseEntity<?> adddelivery(@RequestBody DeliveryDto deliveryDto) {
		try {
			@SuppressWarnings("unused")
			DeliveryStatus newDelivery = statusService.addForDelivery(deliveryDto);
			return Response.success("Delivery added");
		} catch (Exception e) {

			return Response.error(e.getMessage());
		}
	}
	
	@GetMapping("/alldelivery")
	public ResponseEntity<?> getAllDelivery() {
		try {
			List<DeliveryStatus> allDelList = statusService.getAllDeliveryStatus();
			if (!allDelList.isEmpty()) {
				return Response.success(allDelList);
			} else {
				return Response.error("No deliveries");
			}
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
		
	}
	
	@PutMapping("/dStatus/{deliveryId}")
	public ResponseEntity<?> updateStatus(@PathVariable Integer deliveryId, @RequestBody DeliveryStatUpdateDto deliverystatus){
		try {
		String status=statusService.updateDeliveryStatus(deliveryId, deliverystatus);
		System.out.println(deliverystatus.getDeliverystatus());
		System.out.println("deliveryid "+deliveryId);
		return ResponseEntity.ok("Delivery status successfully updated");
		}catch(ResourceNotFoundException e){
			return ResponseEntity.notFound().build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error in updating delivery status");
		}
	}
	
	
 }

