package com.PizzaHut.entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="payments")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payId;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="userId")
	private User users ;
	private double totalAmount;
	private String payStatus;
	private LocalDateTime payTimeStamp;
	private String mode;
	
	public Payment() {
		this.payTimeStamp = LocalDateTime.now();
	}

	public Payment( User users, double totalAmount, String payStatus, String mode) {
		super();
		this.users = users;
		this.totalAmount = totalAmount;
		this.payStatus = payStatus;
		this.payTimeStamp = LocalDateTime.now();
		this.mode = mode;
	}

	
	public void setPayId(int payId) {
		this.payId = payId;
	}
	
	public int getPayId() {
		return payId;
	}


	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	@Override
	public String toString() {
		return String.format("Payments [payId=%s, users=%s, totalAmount=%s, payStatus=%s, payTimeStamp=%s, mode=%s]",
				payId, users, totalAmount, payStatus, payTimeStamp, mode);
	}

	
	

}
