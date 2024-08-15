package com.hbs.hotel_service.hotel_service.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ROOM")
@Setter
@Getter
@NoArgsConstructor
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	
	@Column(name = "ROOM_NUMBER")

	private int roomNumber;
	
	@Column(name = "ROOM_STATUS")

	private String roomStatus;
	
	@Column(name = "IS_ACTIVE")

	private Boolean isActive;

	@Column(name = "ROOM_NAME")

	private String roomName;
	@Column(name = "PRICE")


	private double price;

	@Column(name = "ROOM_CAPACITY")
	private int roomCapacity;


	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "HOTEL_ID")
	private Hotel hotel;

}
