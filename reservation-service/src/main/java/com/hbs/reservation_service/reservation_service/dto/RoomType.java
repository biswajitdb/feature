package com.hbs.reservation_service.reservation_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RoomType {
	
	private int id;
	private String roomName;
	private float rentPerDay;
	private int roomCapacity;
	private Boolean isActive;
}
