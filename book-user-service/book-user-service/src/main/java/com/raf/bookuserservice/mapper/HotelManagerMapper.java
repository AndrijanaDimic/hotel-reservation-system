package com.raf.bookuserservice.mapper;

import org.springframework.stereotype.Component;

import com.raf.bookuserservice.domain.HotelManager;
import com.raf.bookuserservice.dto.HotelManagerCreateDto;
import com.raf.bookuserservice.dto.HotelManagerDto;
import com.raf.bookuserservice.repository.RoleRepository;

@Component
public class HotelManagerMapper {

	private RoleRepository roleRepository;
	
	public HotelManagerMapper( RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
		
	}
	
	public HotelManagerDto hotelManagertoHotelManagerDto(HotelManager hotelManager) {
	   HotelManagerDto hotelManagerDto  = new HotelManagerDto();
	   
	   hotelManagerDto.setEmail(hotelManager.getEmail());
	   hotelManagerDto.setFirstDayAtWork(hotelManager.getFirstDayAtWork());
	   hotelManagerDto.setFirstName(hotelManager.getFirstName());
	   hotelManagerDto.setLastName(hotelManager.getLastName());
	   hotelManagerDto.setPassword(hotelManager.getPassword());
	   hotelManagerDto.setPhoneNumber(hotelManager.getPhoneNumber());
	   hotelManagerDto.setUsername(hotelManager.getUsername());
	   
	   
	   return hotelManagerDto;	
	}
	
	public HotelManager hotelManagerCreateDtoToHotelManager(HotelManagerCreateDto hotelManagerCreateDto) {
		HotelManager hotelManager = new HotelManager();
		
		hotelManager.setEmail(hotelManagerCreateDto.getEmail());
		hotelManager.setFirstDayAtWork(hotelManagerCreateDto.getFirstDayAtWork());
		hotelManager.setFirstName(hotelManagerCreateDto.getFirstName());
		hotelManager.setLastName(hotelManagerCreateDto.getLastName());
		hotelManager.setPassword(hotelManagerCreateDto.getPassword());
	    hotelManager.setPhoneNumber(hotelManagerCreateDto.getPhoneNumber());
		hotelManager.setUsername(hotelManagerCreateDto.getUsername());
		//hotelManager.setHotelId(hotelId);
		hotelManager.setRole(roleRepository.findRoleByName("ROLE_MANAGER").get());
		return hotelManager;
		
	}
	
	
}
