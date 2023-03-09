package com.raf.bookuserservice.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.raf.bookuserservice.dto.HotelManagerCreateDto;
import com.raf.bookuserservice.dto.HotelManagerDto;
import com.raf.bookuserservice.dto.TokenRequestDto;
import com.raf.bookuserservice.dto.TokenResponseDto;
import com.raf.bookuserservice.security.CheckSecurity;
import com.raf.bookuserservice.service.HotelManagerService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")

@RequestMapping("/manager")
public class HotelManagerController {

	private HotelManagerService hotelManagerService;
	
	public HotelManagerController(HotelManagerService hotelManagerService) {
		this.hotelManagerService = hotelManagerService;
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
	    @CheckSecurity(roles = {"ROLE_ADMIN", "ROLE_USER"})
	    public ResponseEntity<Page<HotelManagerDto>> getAllUsers(@RequestHeader("Authorization") String authorization,
	    		Pageable pageable) {

		return new ResponseEntity<>(hotelManagerService.findAll(pageable), HttpStatus.OK);
	  }
	  

	    @ApiOperation(value = "Register user")
	    @PostMapping
	    public ResponseEntity<HotelManagerDto> saveUser(@RequestBody @Valid HotelManagerCreateDto hotelManagerCreateDto) {
	        return new ResponseEntity<>(hotelManagerService.add(hotelManagerCreateDto), HttpStatus.CREATED);
	    }

	    @ApiOperation(value = "Login")
	    @PostMapping("/login")
	    public ResponseEntity<TokenResponseDto> loginUser(@RequestBody @Valid TokenRequestDto tokenRequestDto) {
	        return new ResponseEntity<>(hotelManagerService.login(tokenRequestDto), HttpStatus.OK);
	    }
}
