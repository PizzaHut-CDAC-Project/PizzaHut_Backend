package com.PizzaHut.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CredentialsDto {
	@Email
	@NotBlank
	private String email;
	@NotBlank
	private String password;
	
	public CredentialsDto() {
		// TODO Auto-generated constructor stub
	}

	public CredentialsDto(@Email @NotBlank String email, @NotBlank String password) {
		super();
		this.email = email;
		this.password = password;
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

	@Override
	public String toString() {
		return "CredentialsDto [email=" + email + ", password=" + password + "]";
	}
	
}
