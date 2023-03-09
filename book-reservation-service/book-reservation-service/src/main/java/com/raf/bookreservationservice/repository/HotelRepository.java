package com.raf.bookreservationservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raf.bookreservationservice.domain.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
	
}
