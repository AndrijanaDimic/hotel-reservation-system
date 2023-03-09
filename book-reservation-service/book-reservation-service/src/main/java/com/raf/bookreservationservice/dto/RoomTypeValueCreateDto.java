package com.raf.bookreservationservice.dto;


import javax.validation.constraints.NotNull;

import com.raf.bookreservationservice.domain.RoomType;

public class RoomTypeValueCreateDto {

	@NotNull
	private Long roomTypeValueId;
	@NotNull
	private Double roomTypeValue;
	@NotNull
	private RoomType roomType;
	
	
	public Long getRoomTypeValueId() {
		return roomTypeValueId;
	}
	public void setRoomTypeValueId(Long roomTypeValueId) {
		this.roomTypeValueId = roomTypeValueId;
	}
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
