package com.raf.bookreservationservice.dto;

import java.util.List;


import com.raf.bookreservationservice.domain.Room;

public class HotelDto {
	 
	    private Long hotelId;
		private String name;
		private String description;
		private int numberOfRooms;

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getNumberOfRooms() {
			return numberOfRooms;
		}
		public void setNumberOfRooms(int numberOfRooms) {
			this.numberOfRooms = numberOfRooms;
		}
		public Long getHotelId() {
			return hotelId;
		}
		public void setHotelId(Long hotelId) {
			this.hotelId = hotelId;
		}
		
	    
}
