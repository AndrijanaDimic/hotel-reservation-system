package com.raf.bookreservationservice.dto;


import com.raf.bookreservationservice.domain.Date;
import com.raf.bookreservationservice.domain.DateCreateDto;
import com.raf.bookreservationservice.domain.RoomType;

public class ReservationCreateDto {
	
	private Long hotelId;
	private DateCreateDto from;
	private DateCreateDto till;
	private RoomType roomType;
	


    private Long clientId;
    
 
	public DateCreateDto getFrom() {
		return from;
	}
	public void setFrom(DateCreateDto from) {
		this.from = from;
	}
	public DateCreateDto getTill() {
		return till;
	}
	public void setTill(DateCreateDto till) {
		this.till = till;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	
}
