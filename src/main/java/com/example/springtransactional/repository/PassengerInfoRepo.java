package com.example.springtransactional.repository;

import com.example.springtransactional.model.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerInfoRepo extends JpaRepository<PassengerInfo, Long> {
}
