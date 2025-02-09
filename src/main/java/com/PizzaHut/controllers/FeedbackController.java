package com.PizzaHut.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PizzaHut.entities.Feedback;
import com.PizzaHut.services.FeedBackService;
import com.app.custom_exceptions.ResourceNotFoundException;

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
	
	@GetMapping("/feedbackList")
	public ResponseEntity<?> getAllFeedbacks(){
		List<Feedback> feeds = feedBackService.getAllFeeds();
		if(feeds.size()==0) {
			return ResponseEntity.notFound().build();
		}
		else
			return ResponseEntity.ok(feeds);
	}
	
	@GetMapping("/feedbackList/{id}")
	public ResponseEntity<?> getFeedbackById(@PathVariable Integer id){
		try {
			Feedback feed = feedBackService.fetchFeedbackById(id);
			return ResponseEntity.ok(feed);
		}catch(ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error recieving feedback by id.");
        }
	}
	 
}
