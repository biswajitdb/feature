package com.hbs.hotel_service.hotel_service.controller;

import com.hbs.hotel_service.hotel_service.dto.HotelDto;
import com.hbs.hotel_service.hotel_service.entity.Hotel;
import com.hbs.hotel_service.hotel_service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotelApi")
public class HotelController {
    @Autowired
    private HotelService hotelService; // Inject the HotelService

    @PostMapping("/hotels")
    public ResponseEntity<Hotel> createHotel(@RequestBody HotelDto hotel) {
        Hotel createdHotel = hotelService.addHotel(hotel);
        return new ResponseEntity<>(createdHotel, HttpStatus.CREATED);
    }
    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getHotels();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }
    @GetMapping("/hotels/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable int id) {
        Hotel hotel = hotelService.getHotelById(id);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @GetMapping("/hotels/name/{name}")
    public ResponseEntity<Hotel> getHotelByName(@PathVariable String name) {
        Hotel hotels = hotelService.getHotelByName(name);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }
    @PutMapping("/hotels/{hotelId}")
    public ResponseEntity<String> updateHotel(@PathVariable int hotelId, @RequestBody HotelDto hotelDto) {
        hotelService.updateHotel(hotelId, hotelDto);
        return new ResponseEntity<>("Hotel details has updated", HttpStatus.OK);
    }
}
