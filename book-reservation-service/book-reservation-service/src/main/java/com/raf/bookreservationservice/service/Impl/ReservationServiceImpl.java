package com.raf.bookreservationservice.service.Impl;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.raf.bookreservationservice.client.clientservice.dto.DiscountDto;
import com.raf.bookreservationservice.domain.Date;
import com.raf.bookreservationservice.domain.DateCreateDto;
import com.raf.bookreservationservice.domain.Hotel;
import com.raf.bookreservationservice.domain.Reservation;
import com.raf.bookreservationservice.domain.Room;
import com.raf.bookreservationservice.domain.RoomType;
import com.raf.bookreservationservice.dto.DecrementReservationCountDto;
import com.raf.bookreservationservice.dto.IncrementReservationCountDto;
import com.raf.bookreservationservice.dto.ReservationCreateDto;
import com.raf.bookreservationservice.exception.NotFoundException;
import com.raf.bookreservationservice.listener.helper.MessageHelper;
import com.raf.bookreservationservice.mapper.ReservationMapper;
import com.raf.bookreservationservice.repository.HotelRepository;
import com.raf.bookreservationservice.repository.ReservationRepository;
import com.raf.bookreservationservice.repository.RoomRepository;
import com.raf.bookreservationservice.repository.RoomTypeValueRepository;
import com.raf.bookreservationservice.service.ReservationService;



@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
	
	private ReservationMapper reservationMapper;
	private ReservationRepository reservationRepository;
	private RestTemplate clientServiceRestTemplate;
	private JmsTemplate jmsTemplate;
	private String incrementReservationCountDestination;
	private String decrementReservationCountDestination;
	private MessageHelper messageHelper;
	private RoomRepository roomRepository;
	private RoomTypeValueRepository roomTypeValueRepository;
	private HotelRepository hotelRepository;
	public ReservationServiceImpl(ReservationMapper reservationMapper, ReservationRepository reservationRepository,
			RestTemplate clientServiceRestTemplate, 
			JmsTemplate jmsTemplate,RoomRepository roomRepository,
			@Value("${destination.incrementReservationCount}")String incrementReservationCountDestination,
			@Value("${destination.decrementReservationCount}")String decrementReservationCountDestination,
			HotelRepository hotelRepository
			, MessageHelper messageHelper,RoomTypeValueRepository roomTypeValueRepository){
		this.hotelRepository = hotelRepository;
		this.reservationMapper = reservationMapper;
		this.reservationRepository = reservationRepository;
		this.clientServiceRestTemplate = clientServiceRestTemplate;
		this.jmsTemplate = jmsTemplate;
		this.roomRepository = roomRepository;
		this.incrementReservationCountDestination = incrementReservationCountDestination;
		this.messageHelper = messageHelper;
		this.roomTypeValueRepository = roomTypeValueRepository;
		
	}

	@Override
	public void cancelReservation(ReservationCreateDto reservationCreateDto) {
		
	    // reservationMapper.reservationCreateDtoToReservation(reservationCreateDto).getRoomId();
	      
	      Hotel hotel = hotelRepository.findById(reservationCreateDto.getHotelId())
	    		  .orElseThrow(()-> new NotFoundException("Hotel id is not correct"));
	      hotel.setNumberOfRooms(hotel.getNumberOfRooms()  +  1);
	      hotelRepository.save(hotel);
		  jmsTemplate.convertAndSend(incrementReservationCountDestination, messageHelper.createTextMessage(new DecrementReservationCountDto(reservationCreateDto.getClientId())));
	}

	@Override
	public void  add(ReservationCreateDto reservationCreateDto) {
		
	
		ResponseEntity<DiscountDto> discountDtoResponseEntity = clientServiceRestTemplate.exchange("/user/" + reservationCreateDto.getClientId() + "/discount", 
				 HttpMethod.GET, null, DiscountDto.class);
	
		Reservation reservation = new Reservation();
		reservation.setClientId(reservationCreateDto.getClientId());
		reservation.setHotelId(reservationCreateDto.getHotelId());

		 roomRepository.findAll().forEach(
					room->{
						int closed = 0;
						
						if(room.getRoomType().equals(reservationCreateDto.getRoomType())) {
							if(room.getClosedDates() == null) {
								closed = 0;
							}else {
								for(Date date : room.getClosedDates()) {
									if(date.getDay() == 100) {
										closed = 1;
										break;
									}
								}
							}
							if(closed == 0) {
							
								int numberOfDays = daysBetween( reservationCreateDto.getFrom(), reservationCreateDto.getTill());
							
								Date date = new Date(reservationCreateDto.getFrom().getDay(), reservationCreateDto.getFrom().getMonth(), reservationCreateDto.getFrom().getYear());
								
								fillUpDates(numberOfDays,date, room);
								
								reservation.setRoomId(room.getRoomId());
							}
						}
						
						
						
					}
			);
		 
		 Long i;
		 if(reservationCreateDto.getRoomType() == RoomType.A) {
			 i = (long) 1;
		 }else if (reservationCreateDto.getRoomType() == RoomType.A) {
			 i =  (long) 2;
		 }else {
			 i =  (long) 3;
		 }
		 
		  Hotel hotel = hotelRepository.findById(reservationCreateDto.getHotelId())
	    		  .orElseThrow(()-> new NotFoundException("Hotel id is not correct"));
	      hotel.setNumberOfRooms(hotel.getNumberOfRooms() - 1);
	      hotelRepository.save(hotel);
	     

	      
		 double price;
		 price =  roomTypeValueRepository.findById(i).get().getRoomTypeValue();
	
		 
		 double newPrice = ((100 - discountDtoResponseEntity.getBody().getDiscount()) * price) / 100;
		 
		 reservation.setPrice(newPrice);
		 reservationRepository.save(reservation);
		
		
		 jmsTemplate.convertAndSend(incrementReservationCountDestination, messageHelper.createTextMessage(new IncrementReservationCountDto(reservationCreateDto.getClientId())));
	
	}
	
	public int daysBetween(DateCreateDto from, DateCreateDto till) {
		int numberOfDays = 0 ;
		if(from.getMonth()== till.getMonth() && from.getYear() == till.getYear()) {
			numberOfDays = till.getDay() - from.getDay();
		}else if(from.getMonth() != till.getMonth() && from.getYear() == till.getYear()) {
			
			numberOfDays = till.getDay() + (getMonthDays(from.getMonth(), from.getYear()) - from.getDay());
		}
		return numberOfDays;
	}
	public void fillUpDates(int fullReservationCount, Date date, Room room) {
		int numberOfDays = fullReservationCount;
		
		while(fullReservationCount != numberOfDays){
			fullReservationCount++;
			
			if(limitDays(fullReservationCount, date) == 1) {
			    date.setDay(date.getDay() + fullReservationCount);
				room.getClosedDates().add(date);
			}else {
				if(date.getMonth() + 1 > 12) {
					date.setMonth(1);
					date.setYear(date.getYear() + 1);
				}else {
					date.setMonth(date.getMonth() + 1);
				}
				date.setDay(1);
				
				room.getClosedDates().add(date);
			}
			
			
		}
	}
	
	public int limitDays(int fullReservationCount, Date from) {
		
		int daysInMonth = getMonthDays(from.getMonth(), from.getYear());
	
		
		if(from.getDay() + fullReservationCount > daysInMonth) {
			return -1;
		}
				
		 return 1;
	}
	
	public int getMonthDays(int month, int year) {
		switch(month) {
		case 1: case 3: case 5: case 7: case 8: case 12: {
			return 31;
		}
		case 4 : case 6: case 9: case 10: case 11: {
			return 30;
		}
		case 2 : {
			if((year%400 == 0) || ((year % 100 != 0) && year %4 == 0)){
				return 29;
			}else {
				return 30;
			}
		}
		
		}
		return month;
	}

}
