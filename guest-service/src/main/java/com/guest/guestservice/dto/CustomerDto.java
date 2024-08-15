package com.guest.guestservice.dto;

import java.util.List;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {

	private int id;

	private Boolean status;
	private ProfileDto profile;
	
	private List<StayHistoryDto> stayHistory;


}
