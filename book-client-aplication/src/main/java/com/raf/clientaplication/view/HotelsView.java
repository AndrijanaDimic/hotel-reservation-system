package com.raf.clientaplication.view;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.raf.clientaplication.model.HotelTableModel;
import com.raf.clientaplication.restclient.HotelServiceRestClient;
import com.raf.clientaplication.restclient.dto.HotelDto;
import com.raf.clientaplication.restclient.dto.HotelListDto;

public class HotelsView extends JPanel{

	private HotelTableModel hotelTableModel;
	private JTable hotelTable;
	private HotelServiceRestClient hotelServiceRestClient;
	private JButton jButton;
	
	public HotelsView() throws IllegalAccessException, NoSuchMethodException {
		super();
		this.setSize(400, 400);
		
		hotelTableModel = new HotelTableModel();
		hotelServiceRestClient = new HotelServiceRestClient();
		hotelTable = new JTable(hotelTableModel);
		this.setLayout(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane(hotelTable);
		this.add(scrollPane, BorderLayout.NORTH);
		
		jButton = new JButton("Create order");
		this.add(jButton, BorderLayout.CENTER);
		
		jButton.addActionListener((event) -> {
			System.out.println(hotelTableModel.getHotelListDto().getContent().get(hotelTable.getSelectedRow()).getId());
		});
		
		setVisible(false); // ovde je bio false
	}
	
	public void init() throws IOException {
		this.setVisible(true);
		
		HotelListDto hotelListDto = hotelServiceRestClient.getHotels();
		hotelListDto.getContent().forEach(hotelDto -> {
			System.out.println(hotelDto);
			hotelTableModel.addRow(new Object[] {hotelDto.getTitle(), hotelDto.getDescription(), hotelDto.getId()});
		});
	}

	public HotelTableModel getHotelTableModel() {
		return hotelTableModel;
	}

	public JTable getHotelTable() {
		return hotelTable;
	}
	
	
}
