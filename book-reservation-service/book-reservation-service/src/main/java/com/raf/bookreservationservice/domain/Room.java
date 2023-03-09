package com.raf.bookreservationservice.domain;


import java.util.ArrayList;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity

public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roomId;
	private int RoomNumber;
	private double price;

	@Embedded
	private List<com.raf.bookreservationservice.domain.Date> closedDates;
	@ManyToOne
    private Hotel hotel;

	
	private RoomType roomType;
	
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

	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
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
	public List<com.raf.bookreservationservice.domain.Date> getClosedDates() {
	    closedDates = null;
		return closedDates;
	}
	public void setClosedDates(List<com.raf.bookreservationservice.domain.Date> closedDates) {
		this.closedDates = closedDates;
	}


	
}
