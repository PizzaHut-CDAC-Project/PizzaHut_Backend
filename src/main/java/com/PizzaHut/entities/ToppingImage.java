package com.PizzaHut.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "toppingImage")
public class ToppingImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int toppingImgId;
	@OneToOne
	@JoinColumn(name = "toppingId")
	private Topping toppings;
	
	private String data;
	private LocalDateTime toppingImgTime;

	public ToppingImage() {
		// TODO Auto-generated constructor stub
		this.toppingImgTime =LocalDateTime.now();
	}

	public void setToppingImgId(int toppingImgId) {
		this.toppingImgId = toppingImgId;
	}

	public ToppingImage(int toppingImgId, Topping toppings, String data) {
		super();
		this.toppingImgId = toppingImgId;
		this.toppings = toppings;
		this.data = data;
		this.toppingImgTime =LocalDateTime.now();
	}

	public int getToppingImgId() {
		return toppingImgId;
	}


	public Topping getToppings() {
		return toppings;
	}

	public void setToppings(Topping toppings) {
		this.toppings = toppings;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public LocalDateTime getToppingImgTime() {
		return toppingImgTime;
	}

	public void setToppingImgTime(LocalDateTime toppingImgTime) {
		this.toppingImgTime = toppingImgTime;
	}

	@Override
	public String toString() {
		return "ToppingImages [toppingImgId=" + toppingImgId + ", toppings=" + toppings + "toppingImgTime=" + toppingImgTime + "]";
	}
	
	

}
