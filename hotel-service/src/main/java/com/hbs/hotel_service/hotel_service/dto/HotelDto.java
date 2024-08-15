package com.hbs.hotel_service.hotel_service.dto;

import java.util.List;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class HotelDto {

	private int id;
	

	private String hotelName;
	

	private HotelAddressDto hotelAddress;
	

	private Boolean isActive;
	

	private List<RoomDto> rooms;
}
