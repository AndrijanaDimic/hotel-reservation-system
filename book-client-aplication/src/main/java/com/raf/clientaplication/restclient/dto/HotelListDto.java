package com.raf.clientaplication.restclient.dto;

import java.util.ArrayList;
import java.util.List;

public class HotelListDto {

	private List<HotelDto> content = new ArrayList<>();

	public HotelListDto() {
		super();
	}

	public List<HotelDto> getContent() {
		return content;
	}

	public void setContent(List<HotelDto> content) {
		this.content = content;
	}
	
	
}
