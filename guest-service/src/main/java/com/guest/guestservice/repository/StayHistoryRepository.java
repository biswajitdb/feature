package com.guest.guestservice.repository;

import com.guest.guestservice.entity.StayHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StayHistoryRepository extends JpaRepository<StayHistory, Integer> {
}