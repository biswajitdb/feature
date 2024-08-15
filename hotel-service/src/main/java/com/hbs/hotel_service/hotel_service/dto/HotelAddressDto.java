package com.hbs.hotel_service.hotel_service.dto;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class HotelAddressDto {
	

	private int id;
	

	private String street;
	

	private String city;
	

	private String state;
	

	private int pinCode;
	

	private String country;
}
