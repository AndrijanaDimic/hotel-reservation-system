package com.raf.bookreservationservice.service.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raf.bookreservationservice.dto.RoomDto;
import com.raf.bookreservationservice.dto.RoomTypeValueCreateDto;
import com.raf.bookreservationservice.dto.RoomTypeValueDto;
import com.raf.bookreservationservice.mapper.RoomTypeValueMapper;
import com.raf.bookreservationservice.repository.RoomTypeValueRepository;
import com.raf.bookreservationservice.service.RoomTypeValueService;
@Service
@Transactional
public class RoomTypeValueServiceImpl implements RoomTypeValueService{

	
	private RoomTypeValueRepository roomTypeValueRepository;
	private RoomTypeValueMapper roomTypeValueMapper;
	
	public RoomTypeValueServiceImpl(RoomTypeValueRepository roomTypeValueRepository,
			RoomTypeValueMapper roomTypeValueMapper) {
		super();
		this.roomTypeValueRepository = roomTypeValueRepository;
		this.roomTypeValueMapper = roomTypeValueMapper;
	}

	@Override
	public Page<RoomDto> findAll(Pageable pageable) {
	
		return null;
	}

	@Override
	public RoomTypeValueDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomTypeValueDto add( RoomTypeValueCreateDto roomTypeValueCreateDto) {
		
		return roomTypeValueMapper.roomTypeValueToRoomTypeValueDto(roomTypeValueRepository
				.save(roomTypeValueMapper.roomCreateDtoToRoomTypeValue(roomTypeValueCreateDto)));
	}
	
	
	
	
}
