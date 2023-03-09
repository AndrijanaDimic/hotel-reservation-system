package com.raf.bookuserservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raf.bookuserservice.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	 Optional<Client> findUserByUsernameAndPassword(String username, String password);
}
