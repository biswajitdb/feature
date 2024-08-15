package com.guest.guestservice.service;

import com.guest.guestservice.entity.Customer;
import com.guest.guestservice.entity.Profile;
import com.guest.guestservice.exception.GuestNotFoundException;
import com.guest.guestservice.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileRepository profileRepository;

    public Profile getUserByCustomer(String name) {
        return profileRepository.findByFirstName(name);
    }

}
