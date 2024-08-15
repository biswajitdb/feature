package com.hbs.reservation_service.reservation_service.controller;

import com.hbs.reservation_service.reservation_service.dto.ReservationDto;
import com.hbs.reservation_service.reservation_service.entity.Reservation;
import com.hbs.reservation_service.reservation_service.service.ReservationService;
import io.micrometer.observation.annotation.Observed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservationApi")
@Observed
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/reservations")

    public ResponseEntity<String> addReservation(@RequestBody ReservationDto reservationDto) {
        Reservation reservation=reservationService.addReservation(reservationDto);
        return new ResponseEntity<>("Reservation Created Successfully !!",HttpStatus.CREATED);
    }
}
