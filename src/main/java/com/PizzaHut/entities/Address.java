package com.PizzaHut.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="address")
public class Address {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@JsonIgnore
	private int AddressId;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User user;
	private String plotNo;
	private String streetName;
	private String city;
	private String district;
	private String state;
	private String pincode;
	
	public Address() {
		super();
	}

	public Address(int addressId, User user, String plotNo, String streetName, String city, String district,
			String state, String pincode) {
		super();
		AddressId = addressId;
		this.user = user;
		this.plotNo = plotNo;
		this.streetName = streetName;
		this.city = city;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
	}
	
	public int getAddressId() {
		return AddressId;
	}

	

	public void setAddressId(int addressId) {
		AddressId = addressId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
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

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [AddressId=" + AddressId + ", user=" + user + ", plotNo=" + plotNo + ", streetName="
				+ streetName + ", city=" + city + ", district=" + district + ", state=" + state
				+ ", pincode=" + pincode + "]";
	}

	
}