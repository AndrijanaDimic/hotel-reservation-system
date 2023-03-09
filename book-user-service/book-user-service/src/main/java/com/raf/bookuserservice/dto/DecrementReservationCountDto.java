package com.raf.bookuserservice.dto;

public class DecrementReservationCountDto {

	private Long clientId;

	public DecrementReservationCountDto() {

	}
	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public DecrementReservationCountDto(Long clientId) {
		super();
		this.clientId = clientId;
	}

}
