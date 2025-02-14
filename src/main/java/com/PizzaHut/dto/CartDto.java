package com.PizzaHut.dto;

public class CartDto {
	private int userId;
	private int sizeId;
	private int toppingId;
	private int quantity;
	private double price;
	
	public CartDto() {
		// TODO Auto-generated constructor stub
	}

	public CartDto(int userId, int sizeId, int toppingId, int quantity, double price) {
		super();
		this.userId = userId;
		this.sizeId = sizeId;
		this.toppingId = toppingId;
		this.quantity = quantity;
		this.price = price;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSizeId() {
		return sizeId;
	}

	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}

	public int getToppingId() {
		return toppingId;
	}

	public void setToppingId(int toppingId) {
		this.toppingId = toppingId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "cartDto [userId=" + userId + ", sizeId=" + sizeId + ", toppingId=" + toppingId + ", quantity="
				+ quantity + ", price=" + price + "]";
	}
	
	
}
