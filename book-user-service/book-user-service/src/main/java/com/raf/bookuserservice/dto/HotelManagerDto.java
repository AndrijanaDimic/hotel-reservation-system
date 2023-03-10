package com.raf.bookuserservice.dto;

import java.util.Date;

public class HotelManagerDto {

	private Date firstDayAtWork;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Long managerId;
	
	
	
	public Long getManagerId() {
		return managerId;
	}
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
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
	public Date getFirstDayAtWork() {
		return firstDayAtWork;
	}
	public void setFirstDayAtWork(Date firstDayAtWork) {
		this.firstDayAtWork = firstDayAtWork;
	}
	@Override
	public String toString() {
		return "HotelManagerDto [firstDayAtWork=" + firstDayAtWork + ", username=" + username + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", managerId=" + managerId + "]";
	}

	
	
}
