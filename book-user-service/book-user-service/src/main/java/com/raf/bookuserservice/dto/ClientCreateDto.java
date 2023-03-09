package com.raf.bookuserservice.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class ClientCreateDto{

	
	@NotNull
	 private String reservationCount;
	@NotNull
    private String passportNumber;
	@NotNull
	private String username;
	@NotNull
	private String password;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@Email
	private String email;
	@NotNull
	private String phoneNumber;
	

	public String getReservationCount() {
		return reservationCount;
	}


	public void setReservationCount(String reservationCount) {
		this.reservationCount = reservationCount;
	}


	public String getPassportNumber() {
		return passportNumber;
	}


	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	

}
