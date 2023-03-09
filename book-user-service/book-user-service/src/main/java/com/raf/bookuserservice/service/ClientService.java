package com.raf.bookuserservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.raf.bookuserservice.dto.ClientCreateDto;
import com.raf.bookuserservice.dto.ClientDto;
import com.raf.bookuserservice.dto.ClientUpdateDto;
import com.raf.bookuserservice.dto.DecrementReservationCountDto;
import com.raf.bookuserservice.dto.DiscountDto;
import com.raf.bookuserservice.dto.IncrementReservationCountDto;
import com.raf.bookuserservice.dto.TokenRequestDto;
import com.raf.bookuserservice.dto.TokenResponseDto;

public interface ClientService {
	   Page<ClientDto> findAll(Pageable pageable);

	    ClientDto add(ClientCreateDto userCreateDto);

	   TokenResponseDto login( TokenRequestDto tokenRequestDto);
	    
	   void incrementReservationCount(IncrementReservationCountDto incrementReservationCountDto);
	   void decrementReservationCount(DecrementReservationCountDto decrementReservationCountDto);
	   
	   ClientDto update(Long id, ClientUpdateDto clientUpdateDto);
		
	   DiscountDto findDiscount(Long id);
}
