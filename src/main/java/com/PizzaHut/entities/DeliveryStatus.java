package com.PizzaHut.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="deliverystatus")
public class DeliveryStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deliveryId;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="payId")
	private Payment Payment;
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

	@ManyToOne
	@JoinColumn(name="AddressId")
	private Address address;
	private String deliveryStatus;
	private LocalDateTime deliveryTime;
	
	public DeliveryStatus() {
		super();
		this.deliveryTime = LocalDateTime.now();
	}

	public DeliveryStatus(int deliveryId, Payment Payment, User user, Address address, String deliveryStatus) {
		super();
		this.deliveryId = deliveryId;
		this.Payment = Payment;
		this.user = user;
		this.address = address;
		this.deliveryStatus = deliveryStatus;
		this.deliveryTime = LocalDateTime.now();
	}
	
	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}


	public int getDeliveryId() {
		return deliveryId;
	}

	

	public Payment getPayment() {
		return Payment;
	}

	public void setPayment(Payment Payment) {
		this.Payment = Payment;
	}

	public User getuser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public LocalDateTime getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(LocalDateTime deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	@Override
	public String toString() {
		return "DeliveryStatus [deliveryId=" + deliveryId + ", Payment=" + Payment + ", user=" + user + ", address="
				+ address + ", deliveryStatus=" + deliveryStatus + ", deliveryTime=" + deliveryTime + "]";
	}

	
	
}
