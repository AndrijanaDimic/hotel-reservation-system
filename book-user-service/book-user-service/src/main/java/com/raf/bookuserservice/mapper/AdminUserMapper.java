package com.raf.bookuserservice.mapper;

import org.springframework.stereotype.Component;

import com.raf.bookuserservice.domain.AdminUser;
import com.raf.bookuserservice.domain.User;
import com.raf.bookuserservice.dto.AdminUserCreateDto;
import com.raf.bookuserservice.dto.AdminUserDto;
import com.raf.bookuserservice.dto.UserDto;
import com.raf.bookuserservice.repository.RoleRepository;
@Component
public class AdminUserMapper{

	private RoleRepository roleRepository;
	
	public AdminUserMapper(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	//pravi se objekat za koriscenje u servisima
	public AdminUserDto adminUsertoAdminUserDto(AdminUser adminUser) {
		AdminUserDto userDto = new AdminUserDto();
		userDto.setAdminId(adminUser.getAdminId());
		userDto.setUsername(adminUser.getUsername());
		userDto.setPassword(adminUser.getPassword());
		userDto.setFirstName(adminUser.getFirstName());
		userDto.setLastName(adminUser.getLastName());
		userDto.setEmail(adminUser.getEmail());
		userDto.setPhoneNumber(adminUser.getPhoneNumber());
	
		return (AdminUserDto) userDto;
	}
	
	//pravi se entitet za bazu 
	public AdminUser adminUserCreateDtoToAdminUser(AdminUserCreateDto adminUserCreateDto) {
	
		AdminUser adminUser = new AdminUser();
		adminUser.setAdminId(adminUserCreateDto.getAdminId());
		adminUser.setEmail(adminUserCreateDto.getEmail());
		adminUser.setFirstName(adminUserCreateDto.getFirstName());
		adminUser.setLastName(adminUserCreateDto.getLastName());
		adminUser.setPassword(adminUserCreateDto.getPassword());
		adminUser.setPhoneNumber(adminUserCreateDto.getPhoneNumber());
		adminUser.setUsername(adminUserCreateDto.getUsername());
		adminUser.setRole(roleRepository.findRoleByName("ROLE_ADMIN").get());
		return (AdminUser) adminUser;
		
	}
	
	
	
}
