package com.hbs.reservation_service.reservation_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Profiledto {
	
	private int id;
	private String firstName;
	private String lastName;
	private String emailid;
	private long mobileNumber;
	private String street;
	private String city;
	private String state;
	private int pinCode;
	private String country;
	
}
