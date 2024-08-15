package com.hbs.payment_service.controller;

import com.hbs.payment_service.entity.Payment;
import com.hbs.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paymentApi")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payments")
    public ResponseEntity<Payment> addPayment(@RequestBody Payment paymentDto) {
        Payment payment = paymentService.addPayment(paymentDto);
        return new ResponseEntity<>(payment, HttpStatus.CREATED);
    }
    @GetMapping("/payments/{reservationId}")
    public ResponseEntity<Payment> getPaymentByReservationId(@PathVariable String reservationId) {
        Payment payment = paymentService.getPaymentByReservationId(reservationId);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }
}
