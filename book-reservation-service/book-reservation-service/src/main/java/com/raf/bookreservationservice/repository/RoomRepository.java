package com.raf.bookreservationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raf.bookreservationservice.domain.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
