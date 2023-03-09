package com.raf.bookreservationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookReservationServiceApplication {

	// ovo je baza : http://localhost:8084/api/h2-console
	
	public static void main(String[] args) {
		  SpringApplication.run(BookReservationServiceApplication.class, args);
	}
}
