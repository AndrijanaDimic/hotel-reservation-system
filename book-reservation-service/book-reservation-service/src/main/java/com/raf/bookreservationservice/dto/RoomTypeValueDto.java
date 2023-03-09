package com.raf.bookreservationservice.dto;

import javax.persistence.OneToOne;

import com.raf.bookreservationservice.domain.RoomType;

public class RoomTypeValueDto {


	private Double roomTypeValue;
	private RoomType roomType;
	
	public Double getRoomTypeValue() {
		return roomTypeValue;
	}
	public void setRoomTypeValue(Double roomTypeValue) {
		this.roomTypeValue = roomTypeValue;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
}
