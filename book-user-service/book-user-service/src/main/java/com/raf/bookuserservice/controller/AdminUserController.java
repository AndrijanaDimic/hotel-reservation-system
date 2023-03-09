package com.raf.bookuserservice.controller;


import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.raf.bookuserservice.dto.AdminUserCreateDto;
import com.raf.bookuserservice.dto.AdminUserDto;
import com.raf.bookuserservice.dto.ClientDto;
import com.raf.bookuserservice.dto.UserDto;
import com.raf.bookuserservice.security.CheckSecurity;
import com.raf.bookuserservice.service.AdminUserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminUserController {

	private AdminUserService adminUserService;
	
	public AdminUserController(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
		
	}
	  @ApiOperation(value = "Get all users")
	    @ApiImplicitParams({
	            @ApiImplicitParam(name = "page", value = "What page number you want", dataType = "string", paramType = "query"),
	            @ApiImplicitParam(name = "size", value = "Number of items to return", dataType = "string", paramType = "query"),
	            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
	                    value = "Sorting criteria in the format: property(,asc|desc). " +
	                            "Default sort order is ascending. " +
	                            "Multiple sort criteria are supported.")})
	    @GetMapping
	    @CheckSecurity(roles = {"ROLE_ADMIN", "ROLE_USER", "ROLE_MANAGER"})
	    public ResponseEntity<Page<AdminUserDto>> getAllUsers(@RequestHeader("Authorization") String authorization,
                Pageable pageable) {

		return new ResponseEntity<>(adminUserService.findAll(pageable), HttpStatus.OK);
	  }
	  
	  @PutMapping
	  @CheckSecurity(roles = {"ROLE_USER"})
	    public ResponseEntity<ClientDto> banTheUser(@RequestParam("Ban") int ban  ,  @RequestParam("clientId") Long id, @RequestHeader("Authorization") String authorization,
                Pageable pageable) {

		return new ResponseEntity<>(adminUserService.banTheUser(ban, id, pageable), HttpStatus.OK);
	  }
	  
	  
	
	  ///ovo ne trebam - treba da doda admina - mi to radimo rucno 
	    /*@ApiOperation(value = "Register user")
	    @PostMapping
	    public ResponseEntity<AdminUserDto> saveUser(@RequestBody @Valid AdminUserCreateDto adminUserCreateDto) {
	    	//System.out.println(adminUserCreateDto);
	    	return new ResponseEntity<>(adminUserService.add(adminUserCreateDto), HttpStatus.CREATED);
	    }
	    
	    */

}
