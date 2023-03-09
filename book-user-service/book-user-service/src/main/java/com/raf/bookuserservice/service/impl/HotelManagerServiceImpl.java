package com.raf.bookuserservice.service.impl;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.raf.bookuserservice.domain.Client;
import com.raf.bookuserservice.domain.HotelManager;
import com.raf.bookuserservice.dto.HotelManagerCreateDto;
import com.raf.bookuserservice.dto.HotelManagerDto;
import com.raf.bookuserservice.dto.TokenRequestDto;
import com.raf.bookuserservice.dto.TokenResponseDto;
import com.raf.bookuserservice.exception.NotFoundException;
import com.raf.bookuserservice.mapper.HotelManagerMapper;
import com.raf.bookuserservice.repository.HotelManagerRepository;
import com.raf.bookuserservice.security.service.TokenService;
import com.raf.bookuserservice.service.HotelManagerService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service 
@Transactional
public class HotelManagerServiceImpl implements HotelManagerService  {

	private HotelManagerRepository hotelManagerRepository;
	private TokenService tokenService;
	private HotelManagerMapper hotelManagerMapper;
	
	
	public HotelManagerServiceImpl(HotelManagerRepository hotelManagerRepository, TokenService tokenService,
			HotelManagerMapper hotelManagerMapper) {
		super();
		this.hotelManagerRepository = hotelManagerRepository;
		this.tokenService = tokenService;
		this.hotelManagerMapper = hotelManagerMapper;
	}


	@Override
	public Page<HotelManagerDto> findAll(Pageable pageable) {
		return hotelManagerRepository.findAll(pageable).map(hotelManagerMapper:: hotelManagertoHotelManagerDto);
	}


	@Override
	public HotelManagerDto add(HotelManagerCreateDto hotelManagerCreateDto) {
		HotelManager hotelManager = hotelManagerMapper.hotelManagerCreateDtoToHotelManager(hotelManagerCreateDto);
		System.out.println(hotelManager);
		hotelManagerRepository.save(hotelManager);
		return hotelManagerMapper.hotelManagertoHotelManagerDto(hotelManager);
	}


	@Override
	public TokenResponseDto login(TokenRequestDto tokenRequestDto) {
		HotelManager hotelManager = hotelManagerRepository
				.findUserByUsernameAndPassword(tokenRequestDto.getUsername(), tokenRequestDto.getPassword())
				.orElseThrow(()-> new NotFoundException(String 
						.format("User with username: %s and password: %s not found.", tokenRequestDto.getUsername(),
                                tokenRequestDto.getPassword())));
		//Create token payload
        Claims claims = Jwts.claims();
        claims.put("id", hotelManager.getManagerId());
        claims.put("role", hotelManager.getRole().getName());
        //Generate token
        return new TokenResponseDto(tokenService.generate(claims));

	}
	
	
	
}
