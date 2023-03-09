package com.raf.bookreservationservice.mapper;

import org.springframework.stereotype.Component;

import com.raf.bookreservationservice.domain.Reservation;
import com.raf.bookreservationservice.dto.ReservationCreateDto;
import com.raf.bookreservationservice.dto.ReservationDto;
@Component
public class ReservationMapper {

	 public ReservationDto reservationToReservationDto(Reservation reservation) {
	       ReservationDto reservationDto = new ReservationDto();
	       reservationDto.setRoomType(reservation.getRoomType());
	       reservationDto.setPrice(reservation.getPrice());
	   
	        return reservationDto;
	    }
	 
	 public Reservation reservationCreateDtoToReservation (ReservationCreateDto reservationCreateDto) {
		 
		  Reservation reservation = new Reservation();
	      reservation.setHotelId(reservationCreateDto.getHotelId());
	      reservation.setRoomType(reservationCreateDto.getRoomType());
	      reservation.setClientId(reservationCreateDto.getClientId());
	      return reservation;
	    }
}
