package com.example.springtransactional.repository;

import com.example.springtransactional.model.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRespo extends JpaRepository<PaymentInfo, Long> {
}
