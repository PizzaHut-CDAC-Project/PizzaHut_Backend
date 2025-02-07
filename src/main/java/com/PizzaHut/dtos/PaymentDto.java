package com.PizzaHut.dtos;



public class PaymentDto {
	private int userId;
	private int addresspayId;
	private String payStatus;
	private String mode;
	
	public PaymentDto() {
		// TODO Auto-generated constructor stub
	}

	public PaymentDto(int userId, int addresspayId, String payStatus, String mode) {
		super();
		this.userId = userId;
		this.addresspayId = addresspayId;
		this.payStatus = payStatus;
		this.mode = mode;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAddresspayId() {
		return addresspayId;
	}

	public void setAddresspayId(int addresspayId) {
		this.addresspayId = addresspayId;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}


	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
	

	@Override
	public String toString() {
		return "PaymentDto [userId=" + userId + ", addresspayId=" + addresspayId + ", payStatus=" + payStatus
				 + ", mode=" + mode + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
