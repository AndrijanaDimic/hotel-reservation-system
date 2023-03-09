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
import org.springframework.web.bind.annotation.RestController;

import com.raf.bookuserservice.dto.ClientCreateDto;
import com.raf.bookuserservice.dto.ClientDto;
import com.raf.bookuserservice.dto.ClientUpdateDto;
import com.raf.bookuserservice.dto.DiscountDto;
import com.raf.bookuserservice.dto.TokenRequestDto;
import com.raf.bookuserservice.dto.TokenResponseDto;
import com.raf.bookuserservice.security.CheckSecurity;
import com.raf.bookuserservice.service.ClientService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class ClientController {

	private ClientService clientService;
	
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
		
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
	    public ResponseEntity<Page<ClientDto>> getAllUsers(@RequestHeader("Authorization") String authorization,
	    		Pageable pageable) {

		return new ResponseEntity<>(clientService.findAll(pageable), HttpStatus.OK);
	  }
	  

	    @ApiOperation(value = "Register user")
	    @PostMapping
	    public ResponseEntity<ClientDto> saveUser(@RequestBody @Valid ClientCreateDto clientCreateDto) {
	        return new ResponseEntity<>(clientService.add(clientCreateDto), HttpStatus.CREATED);
	    }

	    @ApiOperation(value = "Login")
	    @PostMapping("/login")
	    public ResponseEntity<TokenResponseDto> loginUser(@RequestBody @Valid TokenRequestDto tokenRequestDto) {
	    	if(clientService.login(tokenRequestDto) == null) {
	    		return new ResponseEntity<>(clientService.login(tokenRequestDto), HttpStatus.FORBIDDEN);
	    	}else 
	    		
	        return new ResponseEntity<>(clientService.login(tokenRequestDto), HttpStatus.OK);
	    }
	    
	    @GetMapping("/{id}/discount")
	    public ResponseEntity<DiscountDto> getDiscount(@PathVariable("id") Long id) {
	    	System.out.println(id);
	        return new ResponseEntity<>(clientService.findDiscount(id), HttpStatus.OK);
	    }
	  
	   //@CheckSecurity(roles = {"ROLE_ADMIN", "ROLE_USER"})
	    @PutMapping("/{id}")
	    public ResponseEntity<ClientDto> updateClient(@PathVariable("id")Long id, ClientUpdateDto clientUpdateDto){
	    	return new ResponseEntity<>(clientService.update(id, clientUpdateDto), HttpStatus.OK);
	    }
	  
	    /*@ApiOperation(value = "Register user")
	    @PostMapping
	    public ResponseEntity<AdminUserDto> saveUser(@RequestBody @Valid AdminUserCreateDto adminUserCreateDto) {
	    	//System.out.println(adminUserCreateDto);
	    	return new ResponseEntity<>(adminUserService.add(adminUserCreateDto), HttpStatus.CREATED);
	    }
	    
	    */
	  

}
