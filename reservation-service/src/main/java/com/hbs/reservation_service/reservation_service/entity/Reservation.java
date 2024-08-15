package com.hbs.reservation_service.reservation_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "RESERVATION_DETAILS")
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "HOTEL_ID")
    private int hotelId;


    @Column(name = "CHECK_IN_DATE")
    private String checkInDate;


    @Column(name = "CHECK_OUT_DATE")
    private String checkOutDate;


    @Column(name = "TOTAL_COST")
    private float totalCost;


    @Column(name = "BOOKING_STATUS")
    private String bookingStatus;

    @Column(name = "TRANSACTION_ID")
    private int transactionId;


    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "ROOM_NUMBER")
    private int roomNumber;

    @Column(name = "PAYMENT_STATUS")
    private String paymentStatus;

}
