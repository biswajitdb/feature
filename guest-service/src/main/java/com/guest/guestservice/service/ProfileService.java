package com.guest.guestservice.service;

import com.guest.guestservice.entity.Profile;

public interface ProfileService {
    public Profile getUserByCustomer(String name);
}
