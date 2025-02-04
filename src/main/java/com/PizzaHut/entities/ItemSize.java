package com.PizzaHut.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="itemsize")
public class ItemSize {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sizeId;
	@ManyToOne(cascade =CascadeType.MERGE)
	@JoinColumn(name="itemId")
	private Item item;
	private String size;
	private double price;
	public ItemSize() {
		// TODO Auto-generated constructor stub
	}

	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}

	public ItemSize(int sizeId, Item item, String size, double price) {
		super();
		this.sizeId = sizeId;
		this.item = item;
		this.size = size;
		this.price = price;
	}

	public int getSizeId() {
		return sizeId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
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
		return "ItemSize [sizeId=" + sizeId + ", item=" + item + ", size=" + size + ", price=" + price + "]";
	}
}
