package com.PizzaHut.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.web.multipart.MultipartFile;

public class ToppingImageDto {
	private MultipartFile data;
	@Temporal(TemporalType.TIMESTAMP)
	private Date topTime; 
	
	public ToppingImageDto() {
		// TODO Auto-generated constructor stub
	}

	public ToppingImageDto(MultipartFile data, Date topTime) {
		super();
		this.data = data;
		this.topTime = topTime;
	}

	public MultipartFile getData() {
		return data;
	}

	public void setData(MultipartFile data) {
		this.data = data;
	}

	public Date getTopTime() {
		return topTime;
	}

	public void setTopTime(Date topTime) {
		this.topTime = topTime;
	}

	@Override
	public String toString() {
		return "ToppingImageDto [data=" + data + ", topTime=" + topTime + "]";
	}
	
	
}
