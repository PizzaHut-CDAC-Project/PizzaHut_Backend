package com.PizzaHut.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemid;
	private String type;
	private String itemName;
	private String description;
	

	public Item() {
	}

	public Item(int itemid, String type, String itemName, String description)
//			, ItemImage itemImages) 
	{
		super();
		this.itemid = itemid;
		this.type = type;
		this.itemName = itemName;
		this.description = description;
//		this.itemImages = itemImages;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public int getItemid() {
		return itemid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
//	public ItemImage getItemImages() {
//		return itemImages;
//	}
//
//	public void setItemImages(ItemImage itemImages) {
//		this.itemImages = itemImages;
//	}

	@Override
	public String toString() {
		return "Item [itemid=" + itemid + ", type=" + type + ", itemName=" + itemName + ", description=" + description
				+  "]";
	}

	
}
