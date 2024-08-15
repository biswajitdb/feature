package com.guest.guestservice.repository;

import com.guest.guestservice.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    public Profile findByFirstName(String name);
}