package com.guest.guestservice.controller;

import com.guest.guestservice.dto.CustomerDto;
import com.guest.guestservice.entity.Customer;
import com.guest.guestservice.entity.Profile;
import com.guest.guestservice.service.GuestService;
import com.guest.guestservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerApi")
public class GuestController {
    @Autowired
    private GuestService guestService;
    @Autowired
    private ProfileService profileService;

    @PostMapping("/users")
    public ResponseEntity<Customer> addUser(@RequestBody CustomerDto userDto) {
        Customer user = guestService.addUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<Customer>> getAllUsers() {
        List<Customer> users = guestService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Customer> getUserById(@PathVariable Integer id) {
        Customer user = guestService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/usersProfile/{name}")
    public ResponseEntity<Profile> getUserByUsername(@PathVariable String name) {
        Profile profile = profileService.getUserByCustomer(name);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }
    @PutMapping("/users/{userid}")
    public ResponseEntity<String> updateUser(@PathVariable Integer userid, @RequestBody CustomerDto userDto) {
        Customer user = guestService.updateUser(userid, userDto);
        return new ResponseEntity<>("User" + userid + "has updated", HttpStatus.OK);
    }


}
