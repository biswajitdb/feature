package com.hbs.hotel_service.hotel_service.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
	private Date timeStamp;
	private String message;
	private String details;
}
