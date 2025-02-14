package com.PizzaHut.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "toppings")
public class Toppings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int toppingId;
	

	private String toppingName;
	private double price;
	
	public Toppings() {
		super();
	}

	public Toppings(int toppingId, String toppingName, double price) {
		super();
		this.toppingId = toppingId;
		this.toppingName = toppingName;
		this.price = price;
	}

	public void setToppingId(int toppingId) {
		this.toppingId = toppingId;
	}
	
	public int getToppingId() {
		return toppingId;
	}

	public String getToppingName() {
		return toppingName;
	}

	public void setToppingName(String toppingName) {
		this.toppingName = toppingName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Toppings [toppingId=" + toppingId + ", toppingName=" + toppingName + ", price=" + price + "]";
	}

	

}