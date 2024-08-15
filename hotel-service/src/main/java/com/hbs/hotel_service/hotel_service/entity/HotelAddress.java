package com.hbs.hotel_service.hotel_service.entity;




import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "HOTEL_ADDRESS")
@Setter
@Getter
@NoArgsConstructor
public class HotelAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	@Column(name = "STREET")

	private String street;
	@Column(name = "CITY")

	private String city;
	@Column(name = "STATE")

	private String state;
	@Column(name = "PINCODE")

	private int pinCode;
	@Column(name = "COUNTRY")

	private String country;
}
