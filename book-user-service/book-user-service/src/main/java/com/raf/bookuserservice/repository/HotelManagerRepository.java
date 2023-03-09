package com.raf.bookuserservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raf.bookuserservice.domain.HotelManager;

public interface HotelManagerRepository extends JpaRepository<HotelManager, Long> {
	 Optional<HotelManager> findUserByUsernameAndPassword(String username, String password);
}
