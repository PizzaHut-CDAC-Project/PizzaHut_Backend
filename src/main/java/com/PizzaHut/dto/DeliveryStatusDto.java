package com.PizzaHut.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.PizzaHut.entities.Users;

public class DeliveryStatusDto {
	private int deliveryId;
	private String firstName;
	private String lastName;
	private String email;
	private Users user;
	private String plotNo;
	private String streetName;
	private String city;
	private String pincode;
	private double totalAmount;
	private String payStatus;
	public DeliveryStatusDto(int deliveryId, String firstName, String lastName, String email, Users user, String plotNo,
			String streetName, String city, String pincode, double totalAmount, String payStatus) {
		super();
		this.deliveryId = deliveryId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.user = user;
		this.plotNo = plotNo;
		this.streetName = streetName;
		this.city = city;
		this.pincode = pincode;
		this.totalAmount = totalAmount;
		this.payStatus = payStatus;
	}
	public DeliveryStatusDto() {
		super();
	}
	public int getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getPlotNo() {
		return plotNo;
	}
	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	@Override
	public String toString() {
		return "DeliveryStatusDto [deliveryId=" + deliveryId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", user=" + user + ", plotNo=" + plotNo + ", streetName=" + streetName
				+ ", city=" + city + ", pincode=" + pincode + ", totalAmount=" + totalAmount + ", payStatus="
				+ payStatus + "]";
	}
	
	
	
}
