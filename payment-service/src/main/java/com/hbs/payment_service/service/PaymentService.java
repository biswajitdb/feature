package com.hbs.payment_service.service;

import com.hbs.payment_service.entity.Payment;

public interface PaymentService {
    public Payment addPayment(Payment paymentDto);
    public Payment getPaymentByReservationId(String reservationId);
}
