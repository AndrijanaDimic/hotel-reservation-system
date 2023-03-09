package com.raf.bookreservationservice.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raf.bookreservationservice.dto.RoomCreateDto;
import com.raf.bookreservationservice.dto.RoomDto;
import com.raf.bookreservationservice.dto.RoomUpdateDto;
import com.raf.bookreservationservice.security.CheckSecurity;
import com.raf.bookreservationservice.service.RoomService;


import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController

@RequestMapping("hotel/{hotelId}/room")
public class RoomController {


	private RoomService roomService;
	
	
	public RoomController(RoomService roomService){
		this.roomService = roomService;
		
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
	  public ResponseEntity<Page<RoomDto>> findAll(@RequestHeader("Authorization") String authorization, @ApiIgnore Pageable pageable) {
        return new ResponseEntity<>(roomService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{roomId}")
    @CheckSecurity(roles = {"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<RoomDto> findById(@RequestHeader("Authorization") String authorization, @PathVariable("roomId") Long id) {
        return new ResponseEntity<>(roomService.findById(id), HttpStatus.OK);
    }
    

    @PostMapping
    public ResponseEntity<RoomDto> add(@PathVariable("hotelId") Long hotelId, @RequestBody @Valid RoomCreateDto roomCreateDto) {
    	
      
    	return new ResponseEntity<>(roomService.addRoom(hotelId, roomCreateDto), HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<Page<RoomDto>> update( @RequestParam("from") Integer from,  @RequestParam("to") Integer to
            , @RequestBody @Valid RoomUpdateDto roomUpdateDto , @ApiIgnore Pageable pageable) {

        return new ResponseEntity<>(roomService.update(from, to, roomUpdateDto, pageable), HttpStatus.OK);
    }
	
}
