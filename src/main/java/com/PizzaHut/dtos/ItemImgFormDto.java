package com.PizzaHut.dtos;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

public class ItemImgFormDto {
	private MultipartFile data;
	private LocalDateTime time;

	public ItemImgFormDto() {
		// TODO Auto-generated constructor stub
	}

	public ItemImgFormDto(int itemid, MultipartFile image, LocalDateTime time) {
		super();
		this.data = image;
		this.time = time;
	}

	public MultipartFile getData() {
		return data;
	}

	public void setData(MultipartFile data) {
		this.data = data;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "ItemImgFormDto [data=" + data + ", time=" + time + "]";
	}

}
