package com.hbs.reservation_service.reservation_service.client;

import com.hbs.reservation_service.reservation_service.dto.Hoteldto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface Hotelclient {
    @GetExchange("/hotelApi/hotels/name/{name}")
    public Hoteldto getHotelsByName(@PathVariable String name);
}
