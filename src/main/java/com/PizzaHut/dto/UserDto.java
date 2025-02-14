package com.PizzaHut.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDto {
	
	private String firstName;
	
	private String lastName;
	@Email
	@NotBlank
	private String email;
	@Email
	@NotBlank
	private String password;
	
	private String phoneNo;
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}

	public UserDto( String firstName, String lastName, @Email @NotBlank String email,
			@Email @NotBlank String password, String phoneNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return String.format(
				"UserDto [firstName=%s, lastName=%s, email=%s, password=%s, phoneNo=%s]",
				firstName, lastName, email, password,phoneNo);
	}

	
}
