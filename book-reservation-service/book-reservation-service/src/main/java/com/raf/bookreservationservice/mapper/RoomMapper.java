package com.raf.bookreservationservice.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.raf.bookreservationservice.domain.Date;
import com.raf.bookreservationservice.domain.Hotel;
import com.raf.bookreservationservice.domain.Room;
import com.raf.bookreservationservice.dto.RoomCreateDto;
import com.raf.bookreservationservice.dto.RoomDto;
@Component
public class RoomMapper {
	 public RoomDto roomToRoomDto(Room room) {
	       RoomDto roomDto = new RoomDto();
	       roomDto.setPrice(room.getPrice());
	       roomDto.setRoomNumber(room.getRoomNumber());
	       roomDto.setRoomType(room.getRoomType());
	        return roomDto;
	    }
	 
	 public Room roomCreateDtoToRoom (RoomCreateDto roomCreateDto, Hotel hotel) {
		 
	       Room room = new Room();
	       room.setRoomId(roomCreateDto.getRoomId());
	       room.setRoomType(roomCreateDto.getRoomType());
	       room.setRoomId(room.getRoomId());
	       room.setRoomNumber(room.getRoomNumber());
	       room.setHotel(hotel);
	       room.setRoomType(room.getRoomType());
	       List<Date> datumi = new ArrayList<Date>();
	       room.getClosedDates();
	        return room;
	    }
	
	
}
