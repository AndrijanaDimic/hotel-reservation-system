package com.raf.bookreservationservice.service.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raf.bookreservationservice.dto.HotelCreateDto;
import com.raf.bookreservationservice.dto.HotelDto;
import com.raf.bookreservationservice.exception.NotFoundException;
import com.raf.bookreservationservice.mapper.HotelMapper;
import com.raf.bookreservationservice.repository.HotelRepository;
import com.raf.bookreservationservice.service.HotelService;


@Service
@Transactional
public class HotelServiceImpl implements HotelService{

	private HotelRepository hotelRepository;
	private HotelMapper hotelMapper;
	
	
	public HotelServiceImpl(HotelRepository hotelRepository, HotelMapper hotelMapper) {
		super();
		this.hotelRepository = hotelRepository;
		this.hotelMapper = hotelMapper;
	}
	@Override
	public Page<HotelDto> findAll(Pageable pageable) {
		
		return hotelRepository.findAll(pageable).
				map(hotelMapper :: hotelToHotelDto);
	
	}
	@Override
	public HotelDto findById(Long id) {
	
		return hotelRepository.findById(id)
				.map(hotelMapper::hotelToHotelDto)
				.orElseThrow(()-> new NotFoundException(String.format("Hotel with : %d does not exist", id)));
	}
	
	@Override
	public HotelDto add(HotelCreateDto hotelCreateDto) {
		return hotelMapper.hotelToHotelDto(hotelRepository.save(hotelMapper.hotelCreateDtoToHotel(hotelCreateDto)));
	}
	
	
}
