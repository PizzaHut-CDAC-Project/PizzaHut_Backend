package com.PizzaHut.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PizzaHut.dao.FeedBackDao;
import com.PizzaHut.entities.Feedback;
import com.app.custom_exceptions.ResourceNotFoundException;

@Service
@Transactional
public class FeedBackService {

	@Autowired
	private FeedBackDao feedbackDao;

	//add new feedback to list
	public Feedback addNewFeedback(Feedback feedback) {
		feedbackDao.save(feedback);
		return feedback;	
	}

	public List<Feedback> getAllFeeds() {
		return feedbackDao.findAll();
	}
	public Feedback fetchFeedbackById(Integer id) {
		Feedback feed = feedbackDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("invalid feedback id"));
		return feed;
	}
	

}
