package com.hbs.hotel_service.hotel_service.service;

import com.hbs.hotel_service.hotel_service.dto.HotelDto;
import com.hbs.hotel_service.hotel_service.entity.Hotel;

import java.util.List;

public interface HotelService {
    public Hotel addHotel(HotelDto hotelDto);
    public List<Hotel> getHotels();
    public Hotel getHotelById(int id);
    public Hotel getHotelByName(String name);
    public Hotel updateHotel(int id, HotelDto hotelDto);
}
