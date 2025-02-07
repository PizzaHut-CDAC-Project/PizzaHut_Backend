package com.PizzaHut.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int feedbackId;
	@Column(name="FirstName")
	private String firstName;	
	@Column(name="LastName")
	private String lastName;
	private String email;
	private String phoneNo;
	private String feedback;
	private LocalDateTime feedBackTime;
	

	
	public Feedback() {
		super();
		this.feedBackTime = LocalDateTime.now();
	}

	public Feedback(int feedbackId, String firstName, String lastName, String email, String phoneNo, String feedback) {
		super();
		this.feedbackId = feedbackId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.feedback = feedback;
		this.feedBackTime = LocalDateTime.now();
	}

	
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public int getFeedbackId() {
		return feedbackId;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public LocalDateTime getFeedBackTime() {
		return feedBackTime;
	}

	public void setFeedBackTime(LocalDateTime feedBackTime) {
		this.feedBackTime = feedBackTime;
	}

	@Override
	public String toString() {
		return String.format(
				"Feedback [feedbackId=%s, firstName=%s, lastName=%s, email=%s, phoneNo=%s, feedback=%s, feedBackTime=%s]",
				feedbackId, firstName, lastName, email, phoneNo, feedback, feedBackTime);
	}

	
}
