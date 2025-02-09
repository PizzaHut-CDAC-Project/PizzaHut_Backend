package com.PizzaHut.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PizzaHut.daos.FeedBackDao;
import com.PizzaHut.entities.Feedback;

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

	 

}
