package com.PizzaHut.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PizzaHut.entities.Feedback;
import com.PizzaHut.services.FeedBackService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	private FeedBackService feedBackService;
	
	//add new feedback to list
	@PostMapping("/addFeedback")
	public ResponseEntity<?> addFeedback(@RequestBody Feedback feedback)
	{
		try {
			@SuppressWarnings("unused")
			Feedback newFeed=feedBackService.addNewFeedback(feedback);
			return Response.success("Feedback added");
			
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}
	
	 
}
