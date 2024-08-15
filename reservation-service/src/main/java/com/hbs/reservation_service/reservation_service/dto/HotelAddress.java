package com.hbs.reservation_service.reservation_service.dto;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class HotelAddress {
	
	private int id;
	private String street;
	private String city;
	private String state;
	private int pinCode;
	private String country;
	
}
