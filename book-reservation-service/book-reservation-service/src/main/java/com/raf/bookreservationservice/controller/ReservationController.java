package com.raf.bookreservationservice.controller;


import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raf.bookreservationservice.domain.Date;
import com.raf.bookreservationservice.domain.DateCreateDto;
import com.raf.bookreservationservice.dto.DateDto;
import com.raf.bookreservationservice.dto.ReservationCreateDto;
import com.raf.bookreservationservice.service.ReservationService;

@RestController

@RequestMapping("/reservation")
public class ReservationController {


	private ReservationService reservationService;

	public ReservationController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@PostMapping
    public ResponseEntity<Void> addReservation(@RequestBody @Valid ReservationCreateDto reservationCreateDto) {
		System.out.println(reservationCreateDto);
        reservationService.add(reservationCreateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
	public ResponseEntity<Void> cancelReservation(@RequestBody @Valid ReservationCreateDto reservationCreateDto) {
		 reservationService.cancelReservation(reservationCreateDto);
		 return new ResponseEntity<>(HttpStatus.OK);
	}

}
