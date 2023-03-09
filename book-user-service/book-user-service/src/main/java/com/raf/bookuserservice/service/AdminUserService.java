package com.raf.bookuserservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.raf.bookuserservice.dto.AdminUserCreateDto;
import com.raf.bookuserservice.dto.AdminUserDto;
import com.raf.bookuserservice.dto.ClientDto;


public interface AdminUserService {
	
	 Page<AdminUserDto> findAll(Pageable pageable);
	 
	 AdminUserDto add(AdminUserCreateDto  userCreateDto);

	 ClientDto banTheUser(int ban,  Long clientDto, Pageable pageable);

}
