package com.raf.bookuserservice.service.impl;


import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.raf.bookuserservice.domain.AdminUser;
import com.raf.bookuserservice.domain.Client;
import com.raf.bookuserservice.dto.AdminUserCreateDto;
import com.raf.bookuserservice.dto.AdminUserDto;
import com.raf.bookuserservice.dto.ClientDto;
import com.raf.bookuserservice.dto.TokenRequestDto;
import com.raf.bookuserservice.dto.TokenResponseDto;
import com.raf.bookuserservice.dto.UserDto;
import com.raf.bookuserservice.exception.NotFoundException;
import com.raf.bookuserservice.mapper.AdminUserMapper;
import com.raf.bookuserservice.mapper.ClientMapper;
import com.raf.bookuserservice.repository.AdminUserRepository;
import com.raf.bookuserservice.repository.ClientRepository;
import com.raf.bookuserservice.security.service.TokenService;
import com.raf.bookuserservice.service.AdminUserService;



@Service
@Transactional
public class AdminUserServiceImpl implements AdminUserService{

    private AdminUserRepository adminUserRepository;
    private TokenService tokenService;
    private AdminUserMapper adminUserMapper;
    private ClientRepository clientRepository;
	private ClientMapper clientmapper;
	
    
	

	public AdminUserServiceImpl(AdminUserRepository adminUserRepository, TokenService tokenService,
			AdminUserMapper adminUserMapper, ClientRepository clientRepository, ClientMapper clientmapper) {
		super();
		this.adminUserRepository = adminUserRepository;
		this.tokenService = tokenService;
		this.adminUserMapper = adminUserMapper;
		this.clientRepository = clientRepository;
		this.clientmapper = clientmapper;
	}

	@Override
	public Page<AdminUserDto> findAll(Pageable pageable) {
		return adminUserRepository.findAll(pageable)
				.map(adminUserMapper::adminUsertoAdminUserDto);
	}

	@Override
	public AdminUserDto add(AdminUserCreateDto adminUserCreateDto) {
		//System.out.println(adminUserCreateDto);
		AdminUser adminUser = adminUserMapper.adminUserCreateDtoToAdminUser(adminUserCreateDto);
		System.out.println(adminUser);
		adminUserRepository.save(adminUser);
		return adminUserMapper.adminUsertoAdminUserDto(adminUser);
	}

	@Override
	public ClientDto banTheUser(int ban, Long userId, Pageable pageable) {
	
		Client client = clientRepository.findById(userId)
				.orElseThrow(()-> new NotFoundException(String.format("User with id :  %d not found", userId)));
		 
		if(ban == 1) {
			client.setBanned(true);
		}else {
			 client.setBanned(false);
		}
		 clientRepository.save(client);
		return clientmapper.clientToClientDto(client);
	}

	
	
}
