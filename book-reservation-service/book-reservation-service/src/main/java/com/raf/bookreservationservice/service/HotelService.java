package com.raf.bookreservationservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.raf.bookreservationservice.dto.HotelCreateDto;
import com.raf.bookreservationservice.dto.HotelDto;



public interface HotelService {

	Page<HotelDto> findAll(Pageable pageable);

	HotelDto findById(Long id);

	HotelDto add(HotelCreateDto hotelCreateDto);
	
	

}
