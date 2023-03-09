package com.raf.bookuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookUserServiceApplication {

	// ovo je baza : http://localhost:8084/api/h2-console
		// ovo je swagger : http://localhost:8084/api/swagger-ui.html
    public static void main(String[] args) {
        SpringApplication.run(BookUserServiceApplication.class, args);
    }

}
