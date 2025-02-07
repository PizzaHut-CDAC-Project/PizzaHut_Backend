package com.PizzaHut.dtos;

public class DeliveryStatUpdateDto {
	private String deliverystatus;

	public String getDeliverystatus() {
		return deliverystatus;
	}

	public void setDeliverystatus(String deliverystatus) {
		this.deliverystatus = deliverystatus;
	}

	public DeliveryStatUpdateDto(String deliverystatus) {
		super();
		this.deliverystatus = deliverystatus;
	}

	public DeliveryStatUpdateDto() {
		super();
	}
	
}
