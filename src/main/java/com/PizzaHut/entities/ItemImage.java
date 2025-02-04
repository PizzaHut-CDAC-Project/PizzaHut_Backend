package com.PizzaHut.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "itemImage")
public class ItemImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemImgId;
	@OneToOne
	@JoinColumn(name="itemId")
	private Item item;
	
	private String data;
	@JsonIgnore
	private LocalDateTime itemImgTime;

	public ItemImage(int itemImgId, Item item, String data) {
		super();
		this.itemImgId = itemImgId;
		this.item = item;
		this.data = data;
		this.itemImgTime =LocalDateTime.now();
	}



	public ItemImage() {
		// TODO Auto-generated constructor stub
		this.itemImgTime =LocalDateTime.now();
	}

	

	public int getItemImgId() {
		return itemImgId;
	}

	public Item getItem() {
		return item;
	}
	
	public LocalDateTime getItemImgTime() {
		return itemImgTime;
	}

	public void setItemImgId(int itemImgId) {
		this.itemImgId = itemImgId;
	}


	public void setItem(Item item) {
		this.item = item;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public LocalDateTime getTime() {
		return itemImgTime;
	}

	public void setTime(LocalDateTime itemImgTime) {
		this.itemImgTime = itemImgTime;
	}

	@Override
	public String toString() {
		return "ItemImage [itemImgId=" + itemImgId + ", item=" + item + ", time=" + itemImgTime + "]";
	}
}
