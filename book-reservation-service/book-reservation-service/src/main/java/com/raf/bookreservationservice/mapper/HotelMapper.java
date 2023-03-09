package com.raf.bookreservationservice.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.raf.bookreservationservice.domain.Hotel;
import com.raf.bookreservationservice.domain.Room;
import com.raf.bookreservationservice.dto.HotelCreateDto;
import com.raf.bookreservationservice.dto.HotelDto;
@Component
public class HotelMapper {
	 public HotelDto hotelToHotelDto(Hotel hotel) {
	        HotelDto hotelDto = new HotelDto();
	        hotelDto.setDescription(hotel.getDescription());
	        hotelDto.setName(hotel.getName());
	        hotelDto.setNumberOfRooms(hotel.getNumberOfRooms());
	        hotelDto.setHotelId(hotel.getHotelId());
	   
	        return hotelDto;
	    }
	 
	 public Hotel hotelCreateDtoToHotel (HotelCreateDto hotelCreateDto) {
	        Hotel hotel = new Hotel();
	        hotel.setDescription(hotelCreateDto.getDescription());
	        hotel.setName(hotelCreateDto.getName());
	        hotel.setNumberOfRooms(hotelCreateDto.getNumberOfRooms());
	        hotel.setHotelId(hotelCreateDto.getHotelId());
	        
	        return hotel;
	    }
}
