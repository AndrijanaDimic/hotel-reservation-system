package com.raf.bookreservationservice.dto;


import java.util.Date;
import java.util.List;

import com.raf.bookreservationservice.domain.RoomType;

public class RoomDto {

	private long roomId;
	private int RoomNumber;
	private double price;
	private RoomType roomType;
	private List<Date> closedDates;
	
	
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public int getRoomNumber() {
		return RoomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		RoomNumber = roomNumber;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List<Date> getClosedDates() {
		return closedDates;
	}
	public void setClosedDates(List<Date> closedDates) {
		this.closedDates = closedDates;
	}


	
}
