package com.raf.bookreservationservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.raf.bookreservationservice.dto.RoomDto;
import com.raf.bookreservationservice.dto.RoomTypeValueCreateDto;
import com.raf.bookreservationservice.dto.RoomTypeValueDto;

public interface RoomTypeValueService{
	 Page<RoomDto> findAll(Pageable pageable);

	 RoomTypeValueDto findById(Long id);

	 RoomTypeValueDto add(RoomTypeValueCreateDto roomTypeValueCreateDto);
}
