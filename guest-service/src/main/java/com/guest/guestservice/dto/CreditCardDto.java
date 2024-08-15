package com.guest.guestservice.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDto {

	private int id;
	
	private long cardNumber;

	
	private String expiryDate;
	

	private String cardHolder;
	
	private String cardType;
}