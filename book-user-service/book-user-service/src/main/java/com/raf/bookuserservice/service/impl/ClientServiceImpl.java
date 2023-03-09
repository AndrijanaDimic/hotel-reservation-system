package com.raf.bookuserservice.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.raf.bookuserservice.domain.Client;
import com.raf.bookuserservice.domain.ClientStatus;
import com.raf.bookuserservice.dto.ClientCreateDto;
import com.raf.bookuserservice.dto.ClientDto;
import com.raf.bookuserservice.dto.ClientUpdateDto;
import com.raf.bookuserservice.dto.DecrementReservationCountDto;
import com.raf.bookuserservice.dto.DiscountDto;
import com.raf.bookuserservice.dto.IncrementReservationCountDto;
import com.raf.bookuserservice.dto.TokenRequestDto;
import com.raf.bookuserservice.dto.TokenResponseDto;
import com.raf.bookuserservice.mapper.ClientMapper;
import com.raf.bookuserservice.repository.ClientRepository;
import com.raf.bookuserservice.repository.ClientStatusRepository;
import com.raf.bookuserservice.security.service.TokenService;
import com.raf.bookuserservice.service.ClientService;
import com.raf.bookuserservice.exception.NotFoundException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
@Transactional
public class ClientServiceImpl implements ClientService{
	 private ClientRepository clientRepository;
	 private TokenService tokenService;
	 private ClientMapper clientMapper;
	 private ClientStatusRepository clientStatusRepository;
	 
	
	
	public ClientServiceImpl(ClientRepository clientRepository, TokenService tokenService, ClientMapper clientMapper,
			ClientStatusRepository clientStatusRepository) {
		super();
		this.clientRepository = clientRepository;
		this.tokenService = tokenService;
		this.clientMapper = clientMapper;
		this.clientStatusRepository = clientStatusRepository;
	}


	@Override
	public Page<ClientDto> findAll(Pageable pageable) {
		return clientRepository.findAll(pageable).map(clientMapper::clientToClientDto);
	}


	@Override
	public ClientDto add(ClientCreateDto clientCreateDto) {
		Client client  = clientMapper.clientCreateDtoToClient(clientCreateDto);
		clientRepository.save(client);
		return clientMapper.clientToClientDto(client);
	}
  
	@Override
	public ClientDto update(Long id, ClientUpdateDto clientUpdateDto) {
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Product with id: %d not found.", id)));
		
		client.setEmail(clientUpdateDto.getEmail());
		client.setFirstName(client.getEmail());
		client.setLastName(client.getLastName());
		client.setPassword(client.getPassword());
		client.setPassportNumber(clientUpdateDto.getPassportNumber());
		client.setPhoneNumber(client.getPhoneNumber());
	
		clientRepository.save(client);
		return clientMapper.clientToClientDto(client);
		
	}
   @Override
	public DiscountDto findDiscount(Long id) {
	   System.out.println(id);
		Client client = clientRepository.findById(id)
				.orElseThrow(()-> new NotFoundException(String.format("User with id: %d not found.", id)));
	
		List<ClientStatus> clientStatusList = clientStatusRepository.findAll();
		
		Integer discount = clientStatusList.stream()
				.filter(clientStatus -> clientStatus.getMaxNumberOfReservations() >= client.getNumberOfReservation()
				 && clientStatus.getMinNumberOfReservations() <= client.getNumberOfReservation())
				.findAny()
				.get()
				.getDiscount();
		
		return new DiscountDto(discount);
	}
	
	@Override
	public void incrementReservationCount(IncrementReservationCountDto incrementReservationCountDto) {
		 clientRepository
	                .findById(incrementReservationCountDto.getUserId())
	                .ifPresent(client -> {client.setNumberOfReservation(client.getNumberOfReservation() + 1);
	                clientRepository.save(client);
	                });
	}
	
	@Override
	public TokenResponseDto login(TokenRequestDto tokenRequestDto) {
	
		
		Client client = clientRepository
				.findUserByUsernameAndPassword(tokenRequestDto.getUsername(), tokenRequestDto.getPassword())
				.orElseThrow(()-> new NotFoundException(String 
						.format("User with username: %s and password: %s not found.", tokenRequestDto.getUsername(),
                                tokenRequestDto.getPassword())));
		   //Create token payload
		
		if(client.isBanned()){
			return null;
		}else {
        Claims claims = Jwts.claims();
        claims.put("id", client.getClientId());
        claims.put("role", client.getRole().getName());
        
       
        //Generate token
        return new TokenResponseDto(tokenService.generate(claims));
		}
	}


	@Override
	public void decrementReservationCount(DecrementReservationCountDto decrementReservationCountDto) {
		 clientRepository
         .findById(decrementReservationCountDto.getClientId())
         .ifPresent(client -> {client.setNumberOfReservation(client.getNumberOfReservation() - 1);
          clientRepository.save(client);
         });
	}
	
	



}
