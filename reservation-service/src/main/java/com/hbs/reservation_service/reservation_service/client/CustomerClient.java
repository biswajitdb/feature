package com.hbs.reservation_service.reservation_service.client;


import com.hbs.reservation_service.reservation_service.dto.Profiledto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface CustomerClient {
    @GetExchange("/customerApi/usersProfile/{name}")
    public Profiledto getCustomerByName(@PathVariable String name);
}
