package com.PizzaHut.dto;


import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class FeedbackDto {

	private int feedbackId;
	private int userId;
	private String feedback;
	@Temporal(TemporalType.TIMESTAMP)
	private Date feedBackTime;
	
	public FeedbackDto() {
		// TODO Auto-generated constructor stub
	}

	public FeedbackDto(int feedbackId, int userId, String feedback) {
		super();
		this.feedbackId = feedbackId;
		this.userId = userId;
		this.feedback = feedback;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return String.format("FeedbackDto [feedbackId=%s, userId=%s, feedback=%s]", feedbackId, userId,
				feedback);
	}
	
	
}
