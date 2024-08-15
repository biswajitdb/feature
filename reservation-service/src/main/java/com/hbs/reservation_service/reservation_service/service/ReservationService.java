package com.hbs.reservation_service.reservation_service.service;

import com.hbs.reservation_service.reservation_service.dto.ReservationDto;
import com.hbs.reservation_service.reservation_service.entity.Reservation;

public interface ReservationService {
    public Reservation addReservation(ReservationDto reservation);
}
