package com.hbs.reservation_service.reservation_service.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
	

	private String name;
	private String hotelName;
	private String checkInDate;
	private String checkOutDate;
	private Boolean isActive;
	private double totCost;
	private float totalCost;
	private String bookingStatus;
	private int transactionId;

	private String reservationId;
	private String roomType;

}
