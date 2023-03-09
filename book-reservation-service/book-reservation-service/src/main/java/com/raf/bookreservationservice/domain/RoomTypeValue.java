package com.raf.bookreservationservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class RoomTypeValue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roomTypeValueId;
	private Double roomTypeValue;

	private RoomType roomType;
	
	
	public RoomTypeValue() {
	}


	public RoomTypeValue(Long roomTypeValueId, Double roomTypeValue, RoomType roomType) {
		this.roomTypeValueId = roomTypeValueId;
		this.roomTypeValue = roomTypeValue;
		this.roomType = roomType;
	}


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
