package com.PizzaHut.dto;

public class AddressDto {
	private int userId;
	private String plotNo;
	private String streetName;
	private String city;
	private String district;
	private String state;
	private String pincode;
	
	public AddressDto() {
		// TODO Auto-generated constructor stub
	}

	public AddressDto(int userId, String plotNo, String streetName, String city, String district, String state,
			String pincode) {
		super();
		this.userId = userId;
		this.plotNo = plotNo;
		this.streetName = streetName;
		this.city = city;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public void setSoverignState(String state) {
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
		return "AddressDto [userId=" + userId + ", plotNo=" + plotNo + ", streetName=" + streetName + ", city=" + city
				+ ", district=" + district + ", state=" + state + ", pincode=" + pincode + "]";
	}

	
}