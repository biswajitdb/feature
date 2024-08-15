package com.guest.guestservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "PROFILE_DETAILS")
@Setter
@Getter
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "FIRST_NAME")

    private String firstName;


    @Column(name = "LAST_NAME")

    private String lastName;


    @Column(name = "EMAIL")

    private String emailid;


    @Column(name = "MOBILE_NO")

    private long mobileNumber;

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
