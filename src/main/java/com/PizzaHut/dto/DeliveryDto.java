package com.PizzaHut.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class DeliveryDto {
	private int payId;
	private int addressid;
	private int userId;
	private String deliveryStatus;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false)
	private Date deliveryTime;

	public DeliveryDto() {
		// TODO Auto-generated constructor stub
	}

	public DeliveryDto(int payId, int addressid, int userId, String deliveryStatus, Date deliveryTime) {
		super();
		this.payId = payId;
		this.addressid = addressid;
		this.userId = userId;
		this.deliveryStatus = deliveryStatus;
		this.deliveryTime = deliveryTime;
	}

	public int getPayId() {
		return payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	@Override
	public String toString() {
		return "DeliveryDto [payId=" + payId + ", addressid=" + addressid + ", userId=" + userId + ", deliveryStatus="
				+ deliveryStatus + ", deliveryTime=" + deliveryTime + "]";
	}

}
