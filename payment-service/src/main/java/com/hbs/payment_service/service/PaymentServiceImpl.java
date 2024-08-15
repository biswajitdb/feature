package com.hbs.payment_service.service;

import com.hbs.payment_service.entity.Payment;
import com.hbs.payment_service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment addPayment(Payment paymentDto) {
        return paymentRepository.save(paymentDto);
    }

    @Override
    public Payment getPaymentByReservationId(String reservationId) {
        return paymentRepository.findByReservationID(reservationId);
    }
}
