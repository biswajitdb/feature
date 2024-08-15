package com.hbs.reservation_service.reservation_service.service;

import com.hbs.reservation_service.reservation_service.client.CustomerClient;
import com.hbs.reservation_service.reservation_service.client.Hotelclient;
import com.hbs.reservation_service.reservation_service.client.PaymentClient;
import com.hbs.reservation_service.reservation_service.dto.*;
import com.hbs.reservation_service.reservation_service.entity.Reservation;
import com.hbs.reservation_service.reservation_service.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ReservationServiceImpl implements ReservationService{
    @Autowired
    private CustomerClient customerWebClient;

    @Autowired
    private Hotelclient hotelwebclient;

    @Autowired
    private PaymentClient paymentWebClient;

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Reservation addReservation(ReservationDto reservation) {
        Reservation reservationObj = new Reservation();
        // Using WebClient
        Profiledto profile = customerWebClient.getCustomerByName(reservation.getName());
        if(profile!=null){
           reservationObj.setUserId(profile.getId());
        }

        Hoteldto hoteldto = hotelwebclient.getHotelsByName(reservation.getHotelName());
        if(hoteldto!=null) {
            reservationObj.setHotelId(hoteldto.getId());
            for (Room room : hoteldto.getRooms()) {
                if (room.getIsActive()) {
                    reservationObj.setRoomNumber(room.getRoomNumber());
                }
            }
        }
        Paymentdto paymentdto=paymentWebClient.getPaymentByReservationId(reservation.getReservationId());
        if(paymentdto!=null){
            reservationObj.setTransactionId(paymentdto.getTransactionId());
            reservationObj.setPaymentStatus(paymentdto.getPaymentStatus());
        }
        reservationObj.setCheckInDate(reservation.getCheckInDate());
        reservationObj.setCheckOutDate(reservation.getCheckOutDate());
        reservationObj.setBookingStatus(reservation.getBookingStatus());
        reservationObj.setTotalCost(reservation.getTotalCost());
        reservationObj.setIsActive(reservation.getIsActive());
        return reservationRepository.save(reservationObj);
    }
}
