package com.raf.bookreservationservice.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.raf.bookreservationservice.dto.RoomCreateDto;
import com.raf.bookreservationservice.dto.RoomDto;
import com.raf.bookreservationservice.dto.RoomUpdateDto;

public interface RoomService {
	
	 Page<RoomDto> findAll(Pageable pageable);

	 RoomDto findById(Long id);

	 RoomDto add(RoomCreateDto roomCreateDto);
	
	 Page<RoomDto> update(Integer from, Integer to,  RoomUpdateDto roomUpdateDto, Pageable pageable);
	
	 RoomDto addRoom(Long idHotel, RoomCreateDto roomCreateDto);
}
