package com.hbs.reservation_service.reservation_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Room {
	
	private int id;
	private int roomNumber;
	private String roomStatus;
	private Boolean isActive;
	private RoomType roomType;
	

}
