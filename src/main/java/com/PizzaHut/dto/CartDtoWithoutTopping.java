package com.PizzaHut.dto;

public class CartDtoWithoutTopping {
	private int userId;
	private int sizeId;
	private int quantity;
	private double price;
	
	public CartDtoWithoutTopping() {
		// TODO Auto-generated constructor stub
	}

	public CartDtoWithoutTopping(int userId, int sizeId, int quantity, double price) {
		super();
		this.userId = userId;
		this.sizeId = sizeId;
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
		return "cartDto [userId=" + userId + ", sizeId=" + sizeId + ", quantity="
				+ quantity + ", price=" + price + "]";
	}
	
	
}
