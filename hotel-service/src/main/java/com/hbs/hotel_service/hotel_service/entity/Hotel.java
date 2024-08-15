package com.hbs.hotel_service.hotel_service.entity;

import java.util.List;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "HOTEL")
@Setter
@Getter
@NoArgsConstructor
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	
	@Column(name = "HOTEL_NAME")

	private String hotelName;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "HOTEL_ADDRESS_ID")

	private HotelAddress hotelAddress;
	
	@Column(name = "IS_ACTIVE")

	private Boolean isActive;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy ="hotel")

	private List<Room> rooms;
}
