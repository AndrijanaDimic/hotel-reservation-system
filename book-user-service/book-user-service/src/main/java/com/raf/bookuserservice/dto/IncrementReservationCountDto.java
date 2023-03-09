package com.raf.bookuserservice.dto;

public class IncrementReservationCountDto {
	private Long userId;
	public IncrementReservationCountDto() {
		
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public IncrementReservationCountDto(Long userId) {
		super();
		this.userId = userId;
	}

}
