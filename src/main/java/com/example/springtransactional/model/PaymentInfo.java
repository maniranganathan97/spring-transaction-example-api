package com.example.springtransactional.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class PaymentInfo {
    @Id
    @GeneratedValue
    private long payment_id;
    private double amount;
    private String accountNo;
    private Long passengerId;
}
