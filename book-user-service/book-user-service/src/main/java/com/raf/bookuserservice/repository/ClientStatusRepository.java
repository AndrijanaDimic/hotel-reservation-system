package com.raf.bookuserservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raf.bookuserservice.domain.ClientStatus;

public interface ClientStatusRepository extends JpaRepository<ClientStatus,Long> {

}
