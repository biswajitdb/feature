package com.guest.guestservice.repository;

import com.guest.guestservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Customer, Integer> {


    List<Customer> findByStatus(boolean b);


}