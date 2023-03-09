package com.raf.bookreservationservice.mapper;

import org.springframework.stereotype.Component;

import com.raf.bookreservationservice.domain.RoomTypeValue;
import com.raf.bookreservationservice.dto.RoomTypeValueCreateDto;
import com.raf.bookreservationservice.dto.RoomTypeValueDto;
@Component
public class RoomTypeValueMapper {

	public RoomTypeValueDto roomTypeValueToRoomTypeValueDto(RoomTypeValue roomTypeValue) {
	       RoomTypeValueDto roomTypeValueDto = new RoomTypeValueDto();
	       roomTypeValueDto.setRoomType(roomTypeValue.getRoomType());
	       roomTypeValueDto.setRoomTypeValue(roomTypeValue.getRoomTypeValue());
	       
	        return roomTypeValueDto;
	    }
	 
	 public RoomTypeValue roomCreateDtoToRoomTypeValue (RoomTypeValueCreateDto roomTypeValueCreateDto) {
	       RoomTypeValue roomTypeValue = new RoomTypeValue();
	       roomTypeValue.setRoomType(roomTypeValueCreateDto.getRoomType());
	       roomTypeValue.setRoomTypeValue(roomTypeValueCreateDto.getRoomTypeValue());
	        return roomTypeValue;
	    }
	
}
