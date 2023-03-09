package com.raf.bookreservationservice.controller;



import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raf.bookreservationservice.dto.HotelCreateDto;
import com.raf.bookreservationservice.dto.HotelDto;
import com.raf.bookreservationservice.security.CheckSecurity;
import com.raf.bookreservationservice.service.HotelService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;


@RestController
@RequestMapping("/hotel")
public class HotelController {

	private HotelService hotelService;
	
	
	public HotelController(HotelService hotelService){
		this.hotelService = hotelService;
		
	}
	@ApiOperation(value = "Get all movies")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "What page number you want", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "Number of items to return", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})
	
	    @GetMapping
	    @CheckSecurity(roles = {"ROLE_USER", "ROLE_ADMIN"})
	    public ResponseEntity<Page<HotelDto>> findAll(@RequestHeader("Authorization") String authorization, @ApiIgnore Pageable pageable) {
	        return new ResponseEntity<>(hotelService.findAll(pageable), HttpStatus.OK);
	    }

	    @GetMapping("/{hotelId}")
	    public ResponseEntity<HotelDto> findById(@RequestHeader("Authorization") String authorization, @PathVariable("hotelId") Long hotelId) {
	
	    	return new ResponseEntity<>(hotelService.findById(hotelId), HttpStatus.OK);
	    }
	    

	    @PostMapping
	    public ResponseEntity<HotelDto> add(@RequestBody @Valid HotelCreateDto hotelCreateDto) {
	    	
	        return new ResponseEntity<>(hotelService.add(hotelCreateDto), HttpStatus.CREATED);
	    }
	    
	  
/*
	    @PostMapping
	    @CheckSecurity(roles = {"ROLE_ADMIN"})
	    public ResponseEntity<HotelDto>add(@RequestHeader("Authorization") String authorization, @RequestBody @Valid HotelCreateDto movieCreateDto) {
	        return new ResponseEntity<>(hotelService.add(movieCreateDto), HttpStatus.CREATED);
	    }

	*/
	    

	
	
}
