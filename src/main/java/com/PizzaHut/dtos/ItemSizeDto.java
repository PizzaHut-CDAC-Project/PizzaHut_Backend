package com.PizzaHut.dtos;

public class ItemSizeDto {

	private Integer itemId;
	private String size;
	private double price;

	public ItemSizeDto(Integer itemId, String size, double price) {
		super();
		this.itemId = itemId;
		this.size = size;
		this.price = price;
	}

	public ItemSizeDto() {
		super();
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ItemSizeDto [itemId=" + itemId + ", size=" + size + ", price=" + price + "]";
	}

}
