package com.raf.bookreservationservice.service.Impl;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raf.bookreservationservice.domain.Hotel;
import com.raf.bookreservationservice.dto.RoomCreateDto;
import com.raf.bookreservationservice.dto.RoomDto;
import com.raf.bookreservationservice.dto.RoomUpdateDto;
import com.raf.bookreservationservice.mapper.RoomMapper;
import com.raf.bookreservationservice.repository.HotelRepository;
import com.raf.bookreservationservice.repository.RoomRepository;
import com.raf.bookreservationservice.service.RoomService;


@Service
@Transactional
public class RoomServiceImpl implements RoomService {

	private HotelRepository hotelRepository;
	private RoomMapper roomMapper;
	private RoomRepository roomRepository;
	
	
	public RoomServiceImpl(HotelRepository hotelRepository, RoomRepository roomRepository, RoomMapper roomMapper) {
		super();
		this.hotelRepository = hotelRepository;
		this.roomRepository = roomRepository;
		this.roomMapper = roomMapper;
	}

	@Override
	public Page<RoomDto> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomDto add(RoomCreateDto movieCreateDto) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public RoomDto addRoom(Long hotelId, RoomCreateDto roomCreateDto) {

		Hotel hotel = hotelRepository.findById(hotelId)
				.orElseThrow(()-> new com.raf.bookreservationservice.exception.NotFoundException(String.format("Hotel with id: %d not found.", hotelId)));
		
		return roomMapper.roomToRoomDto(roomRepository.save(roomMapper.roomCreateDtoToRoom(roomCreateDto, hotel)));
		
	}

	@Override
	public Page<RoomDto> update(Integer from, Integer to, RoomUpdateDto roomUpdateDto, Pageable pageable) {
	
		
		 roomRepository.findAll().forEach(
						room->{
							if(room.getRoomNumber() <= to && room.getRoomNumber() >= from) {
								room.setPrice(roomUpdateDto.getPrice());
								room.setRoomType(roomUpdateDto.getRoomType());
								roomRepository.save(room);
							}
						}
				);

		 return roomRepository.findAll(pageable).
					map(roomMapper :: roomToRoomDto);
		
	}
				

	/*@Override
	public RoomDto update(Integer from, Integer to,  RoomUpdateDto roomUpdateDto) {

		Room room = roomRepository.findById(id)
				  .orElseThrow(() -> new NotFoundException(String.format("Product with id: %d not found.", id)));
		room.setPrice(roomUpdateDto.getPrice());
		
		return roomMapper.roomToRoomDto(roomRepository.save(room));
	}
	*/

}
