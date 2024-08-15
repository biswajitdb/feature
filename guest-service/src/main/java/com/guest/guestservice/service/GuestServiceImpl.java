package com.guest.guestservice.service;


import com.guest.guestservice.dto.CustomerDto;
import com.guest.guestservice.entity.Profile;
import com.guest.guestservice.entity.StayHistory;
import com.guest.guestservice.entity.Customer;
import com.guest.guestservice.exception.GuestNotFoundException;
import com.guest.guestservice.repository.GuestRepository;
import com.guest.guestservice.repository.ProfileRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional

public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepository guestRepository;



    @Override
    public Customer addUser(CustomerDto userDto) {
        return convertToEntity(userDto);
    }

    @Override
    public List<Customer> getAllUsers() {
        return guestRepository.findByStatus(true);
    }

    @Override
    public Customer getUserById(Integer userId) {
        Optional<Customer> optionalUser = guestRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            throw new GuestNotFoundException("Unble to find the User");
        }
        return optionalUser.get();
    }

    @Override
    @Transactional
    public Customer updateUser(Integer userId, CustomerDto userDto) {
        Customer existingUser = guestRepository.findById(userId)
                .orElseThrow(() -> new GuestNotFoundException("User not found with id: " + userId));
        Profile profile = existingUser.getProfile();
        profile.setFirstName(userDto.getProfile().getFirstName());
        profile.setLastName(userDto.getProfile().getLastName());
        profile.setEmailid(userDto.getProfile().getEmailid());
        profile.setMobileNumber(userDto.getProfile().getMobileNumber());
        profile.setStreet(userDto.getProfile().getStreet());
        profile.setCity(userDto.getProfile().getCity());
        profile.setState(userDto.getProfile().getState());
        profile.setPinCode(userDto.getProfile().getPinCode());
        profile.setCountry(userDto.getProfile().getCountry());

        return guestRepository.save(existingUser);
    }




    /**
     * Convert a UserDto to a User entity.
     *
     * @param userDto the user DTO
     * @return the user entity
     */
    private Customer convertToEntity(CustomerDto userDto) {
        Customer customer = new Customer();
        customer.setStatus(userDto.getStatus());
        if (userDto.getProfile() != null) {
            Profile profile = new Profile();
            profile.setFirstName(userDto.getProfile().getFirstName());
            profile.setLastName(userDto.getProfile().getLastName());
            profile.setEmailid(userDto.getProfile().getEmailid());
            profile.setMobileNumber(userDto.getProfile().getMobileNumber());
            profile.setStreet(userDto.getProfile().getStreet());
            profile.setCity(userDto.getProfile().getCity());
            profile.setState(userDto.getProfile().getState());
            profile.setPinCode(userDto.getProfile().getPinCode());
            profile.setCountry(userDto.getProfile().getCountry());
            customer.setProfile(profile);
        }

        Customer persistedUser = guestRepository.save(customer);
        if (userDto.getStayHistory()!= null) {
            List<StayHistory> stayHistory = userDto.getStayHistory().stream().map(stayhistorydto -> {
                StayHistory Stayhistory = new StayHistory();
                Stayhistory.setReservationID(stayhistorydto.getReservationID());
                Stayhistory.setUser(persistedUser);
                return Stayhistory;
            }).collect(Collectors.toList());
            persistedUser.setStayHistory(stayHistory);
            guestRepository.save(persistedUser);
        }
        return customer;
    }



}