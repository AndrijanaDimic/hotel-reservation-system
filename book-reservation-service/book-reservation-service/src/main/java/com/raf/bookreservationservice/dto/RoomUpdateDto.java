package com.raf.bookreservationservice.dto;

import javax.validation.constraints.NotNull;

import com.raf.bookreservationservice.domain.RoomType;

public class RoomUpdateDto {
	@NotNull
	private double price;
	@NotNull
	private RoomType roomType;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	
	
	
	
}
