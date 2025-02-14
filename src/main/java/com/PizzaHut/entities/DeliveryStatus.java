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
	private Payments payments;
	@ManyToOne
	@JoinColumn(name="userId")
	private Users users;

	@ManyToOne
	@JoinColumn(name="AddressId")
	private Address address;
	private String deliveryStatus;
	private LocalDateTime deliveryTime;
	
	public DeliveryStatus() {
		super();
		this.deliveryTime = LocalDateTime.now();
	}

	public DeliveryStatus(int deliveryId, Payments payments, Users users, Address address, String deliveryStatus) {
		super();
		this.deliveryId = deliveryId;
		this.payments = payments;
		this.users = users;
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

	

	public Payments getPayments() {
		return payments;
	}

	public void setPayments(Payments payments) {
		this.payments = payments;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
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
		return "DeliveryStatus [deliveryId=" + deliveryId + ", payments=" + payments + ", users=" + users + ", address="
				+ address + ", deliveryStatus=" + deliveryStatus + ", deliveryTime=" + deliveryTime + "]";
	}

	
	
}
