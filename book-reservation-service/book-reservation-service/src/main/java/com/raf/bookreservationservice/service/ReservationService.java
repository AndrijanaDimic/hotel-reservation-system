package com.raf.bookreservationservice.service;


import com.raf.bookreservationservice.domain.DateCreateDto;
import com.raf.bookreservationservice.dto.ReservationCreateDto;


public interface ReservationService {

	 void add(ReservationCreateDto reservationCreateDto);
	 public void cancelReservation(ReservationCreateDto reservationCreateDto);
}
