package com.raf.bookuserservice.mapper;

import org.springframework.stereotype.Component;

import com.raf.bookuserservice.domain.AdminUser;
import com.raf.bookuserservice.domain.Client;
import com.raf.bookuserservice.dto.AdminUserCreateDto;
import com.raf.bookuserservice.dto.ClientCreateDto;
import com.raf.bookuserservice.dto.ClientDto;
import com.raf.bookuserservice.repository.RoleRepository;
@Component
public class ClientMapper {
	private RoleRepository roleRepository;
	//find role by name 
     public ClientMapper(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public ClientDto clientToClientDto(Client client) {
		
		ClientDto clientDto = new ClientDto();
		clientDto.setClientId(client.getClientId());
		clientDto.setEmail(client.getEmail());
		clientDto.setFirstName(client.getFirstName());
		clientDto.setLastName(client.getLastName());
		clientDto.setPassportNumber(client.getPassportNumber());
		clientDto.setPassword(client.getPassword());
		clientDto.setPhoneNumber(client.getPhoneNumber());
		clientDto.setUsername(client.getUsername());
        
		return clientDto;
	}
	

	public Client clientCreateDtoToClient(ClientCreateDto clientCreateDto) {
		Client client = new Client();
		client.setEmail(clientCreateDto.getEmail());
		client.setFirstName(clientCreateDto.getFirstName());
		client.setLastName(clientCreateDto.getLastName());
		client.setPassportNumber(clientCreateDto.getPassportNumber());
		client.setPassword(clientCreateDto.getPassword());
		client.setPhoneNumber(clientCreateDto.getPhoneNumber());
		client.setUsername(clientCreateDto.getUsername());
		int a = 0;
		client.setNumberOfReservation(a);
		client.setRole(roleRepository.findRoleByName("ROLE_USER").get());
		client.setBanned(false);
		
		return client;
	
	}
}
