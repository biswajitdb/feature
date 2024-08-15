package com.guest.guestservice.service;


import com.guest.guestservice.dto.CustomerDto;
import com.guest.guestservice.entity.Customer;

import java.util.List;

public interface GuestService {
    public Customer addUser(CustomerDto userDto);
    public List<Customer> getAllUsers();
    public Customer getUserById(Integer userId);
    public Customer updateUser(Integer userId, CustomerDto userDto);



}
