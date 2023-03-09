package com.raf.bookreservationservice.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.raf.bookreservationservice.domain.RoomType;


public class RoomCreateDto {
	@NotNull
	private int RoomNumber;
	@NotNull
	private RoomType roomType;
	
	@NotNull
	private Long roomId;
	

	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	public int getRoomNumber() {
		return RoomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		RoomNumber = roomNumber;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}


	
}
