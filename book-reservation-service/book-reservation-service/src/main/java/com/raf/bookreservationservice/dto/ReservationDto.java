package com.raf.bookreservationservice.dto;

import com.raf.bookreservationservice.domain.RoomType;

public class ReservationDto {

	private RoomType roomType;
	private double price;
	
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
