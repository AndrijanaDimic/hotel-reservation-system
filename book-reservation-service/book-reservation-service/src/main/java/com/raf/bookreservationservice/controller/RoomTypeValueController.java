package com.raf.bookreservationservice.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raf.bookreservationservice.dto.RoomTypeValueCreateDto;
import com.raf.bookreservationservice.dto.RoomTypeValueDto;
import com.raf.bookreservationservice.service.RoomTypeValueService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/roomTypeValue")
public class RoomTypeValueController {

	private RoomTypeValueService roomTypeValueService;

	public RoomTypeValueController(RoomTypeValueService roomTypeValueService) {
		super();
		this.roomTypeValueService = roomTypeValueService;
	}
	@ApiOperation(value = "Get all movies")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "What page number you want", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "Number of items to return", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})
	
	
	 @PostMapping
	    public ResponseEntity<RoomTypeValueDto> add( @RequestBody @Valid RoomTypeValueCreateDto roomTypeValueCreateDto) {
	    	
	    	return new ResponseEntity<>(roomTypeValueService.add(roomTypeValueCreateDto), HttpStatus.OK);
	    }
	
}
