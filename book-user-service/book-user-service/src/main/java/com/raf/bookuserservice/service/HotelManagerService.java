package com.raf.bookuserservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.raf.bookuserservice.dto.HotelManagerCreateDto;
import com.raf.bookuserservice.dto.HotelManagerDto;
import com.raf.bookuserservice.dto.TokenRequestDto;
import com.raf.bookuserservice.dto.TokenResponseDto;

public interface HotelManagerService {

	  Page<HotelManagerDto> findAll(Pageable pageable);

	    HotelManagerDto add(HotelManagerCreateDto hotelManagerCreateDto);

	   TokenResponseDto login(TokenRequestDto tokenRequestDto);
}
