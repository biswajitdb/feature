package com.hbs.hotel_service.hotel_service.dto;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RoomDto {

	private int id;
	

	private int roomNumber;
	

	private String roomStatus;


	private Boolean isActive;


	private String roomName;


	private float price;


	private int roomCapacity;



}
