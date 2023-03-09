package com.raf.bookreservationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raf.bookreservationservice.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
