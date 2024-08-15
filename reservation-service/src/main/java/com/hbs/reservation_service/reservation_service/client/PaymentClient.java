package com.hbs.reservation_service.reservation_service.client;

import com.hbs.reservation_service.reservation_service.dto.Paymentdto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface PaymentClient {
    @GetExchange("/paymentApi/payments/{reservationId}")
    public Paymentdto getPaymentByReservationId(@PathVariable String reservationId);
}
