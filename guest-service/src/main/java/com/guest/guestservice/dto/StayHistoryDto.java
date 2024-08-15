package com.guest.guestservice.dto;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StayHistoryDto {

	private int id;

	private String reservationID;
	

	private CustomerDto userDto;
}
