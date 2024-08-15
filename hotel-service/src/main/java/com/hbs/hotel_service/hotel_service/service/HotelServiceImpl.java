package com.hbs.hotel_service.hotel_service.service;

import com.hbs.hotel_service.hotel_service.dto.HotelDto;
import com.hbs.hotel_service.hotel_service.dto.RoomDto;
import com.hbs.hotel_service.hotel_service.entity.Hotel;
import com.hbs.hotel_service.hotel_service.entity.HotelAddress;
import com.hbs.hotel_service.hotel_service.entity.Room;
import com.hbs.hotel_service.hotel_service.exception.HotelNotFoundException;
import com.hbs.hotel_service.hotel_service.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService{



    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel addHotel(HotelDto hotelDto) {
        Hotel hotel = new Hotel();
        hotel.setHotelName(hotelDto.getHotelName());
        hotel.setIsActive(hotelDto.getIsActive());

        HotelAddress hotelAddress = new HotelAddress();
        hotelAddress.setStreet(hotelDto.getHotelAddress().getStreet());
        hotelAddress.setCity(hotelDto.getHotelAddress().getCity());
        hotelAddress.setState(hotelDto.getHotelAddress().getState());
        hotelAddress.setPinCode(hotelDto.getHotelAddress().getPinCode());
        hotelAddress.setCountry(hotelDto.getHotelAddress().getCountry());

        hotel.setHotelAddress(hotelAddress);

        List<Room> rooms = new ArrayList<>();
        for (RoomDto roomDto : hotelDto.getRooms()) {
            Room room = new Room();
            room.setRoomNumber(roomDto.getRoomNumber());
            room.setRoomStatus(roomDto.getRoomStatus());
            room.setIsActive(roomDto.getIsActive());
            room.setPrice(roomDto.getPrice());
            room.setRoomCapacity(roomDto.getRoomCapacity());
            room.setRoomName(roomDto.getRoomName());
            room.setHotel(hotel);
            rooms.add(room);
        }
        hotel.setRooms(rooms);

        return hotelRepository.save(hotel);

    }

    @Override
    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(int hotelId) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
        if (!optionalHotel.isPresent()) {
            throw new HotelNotFoundException("Hotel not found.");
        }
        return optionalHotel.get();
    }

    @Override
    public Hotel updateHotel(int id, HotelDto hotelDto) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        if (optionalHotel.isPresent()) {
            Hotel existingHotel = optionalHotel.get();

            // Update hotel properties
            existingHotel.setHotelName(hotelDto.getHotelName());
            existingHotel.setIsActive(hotelDto.getIsActive());

            // Update hotel address
            HotelAddress hotelAddress = existingHotel.getHotelAddress();
            if (hotelAddress == null) {
                hotelAddress = new HotelAddress();
                existingHotel.setHotelAddress(hotelAddress);
            }
            hotelAddress.setStreet(hotelDto.getHotelAddress().getStreet());
            hotelAddress.setCity(hotelDto.getHotelAddress().getCity());
            hotelAddress.setState(hotelDto.getHotelAddress().getState());
            hotelAddress.setPinCode(hotelDto.getHotelAddress().getPinCode());
            hotelAddress.setCountry(hotelDto.getHotelAddress().getCountry());

            // Update hotel rooms
            List<Room> rooms = new ArrayList<>();
            for (com.hbs.hotel_service.hotel_service.dto.RoomDto roomDto : hotelDto.getRooms()) {
                Room room = new Room();
                room.setRoomNumber(roomDto.getRoomNumber());
                room.setRoomStatus(roomDto.getRoomStatus());
                room.setIsActive(roomDto.getIsActive());
                room.setPrice(roomDto.getPrice());
                room.setRoomCapacity(roomDto.getRoomCapacity());
                room.setRoomName(roomDto.getRoomName());
                room.setHotel(existingHotel);
                rooms.add(room);
            }
            existingHotel.setRooms(rooms);

            return hotelRepository.save(existingHotel);
        } else {
            throw new RuntimeException("Hotel not found with id: " + hotelDto.getId());
        }
    }

    @Override
    public Hotel getHotelByName(String name) {
        Hotel hotel = hotelRepository.findByHotelName(name);
        if (hotel != null) {
            return hotel;

        }else {
            throw new HotelNotFoundException("Hotel not found.");
        }
    }
    }



