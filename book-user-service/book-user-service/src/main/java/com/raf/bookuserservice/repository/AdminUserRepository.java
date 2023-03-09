package com.raf.bookuserservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raf.bookuserservice.domain.AdminUser;
import com.raf.bookuserservice.domain.User;

public interface  AdminUserRepository  extends JpaRepository<AdminUser, Long>{

	   Optional<AdminUser> findUserByUsernameAndPassword(String username, String password);
}
