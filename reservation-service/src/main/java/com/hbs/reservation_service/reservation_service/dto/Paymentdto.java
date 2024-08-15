package com.hbs.reservation_service.reservation_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Paymentdto {
	
	private String paymentMethod;
	private String paymentStatus;
	private int transactionId;
	
}
