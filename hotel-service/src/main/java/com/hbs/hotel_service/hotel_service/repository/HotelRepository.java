package com.hbs.hotel_service.hotel_service.repository;

import com.hbs.hotel_service.hotel_service.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    public Hotel findByHotelName(String hotelName);
}