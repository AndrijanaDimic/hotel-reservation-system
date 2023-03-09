package com.raf.clientaplication.model;

import javax.swing.table.DefaultTableModel;

import com.raf.clientaplication.restclient.dto.HotelDto;
import com.raf.clientaplication.restclient.dto.HotelListDto;

public class HotelTableModel extends DefaultTableModel{
	
	public HotelTableModel() throws IllegalAccessException, NoSuchMethodException {
		super(new String[]{"Title", "Description"}, 0);
	}

	private HotelListDto hotelListDto = new HotelListDto();
	
	@Override
	public void addRow(Object[] row) {
		super.addRow(row);
		HotelDto dto = new HotelDto();
		dto.setTitle(String.valueOf(row[0]));
		dto.setDescription(String.valueOf(row[1]));
		dto.setId(Long.valueOf(String.valueOf(row[2])));
		hotelListDto.getContent().add(dto);
	}

	public HotelListDto getHotelListDto() {
		return hotelListDto;
	}

	public void setHotelListDto(HotelListDto hotelListDto) {
		this.hotelListDto = hotelListDto;
	}
	
	
	

}
