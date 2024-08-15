package com.hbs.reservation_service.reservation_service.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hoteldto {

	private int id;
	private String hotelName;
	private HotelAddress hotelAddress;
	private Boolean isActive;
	private List<Room> rooms;
}
