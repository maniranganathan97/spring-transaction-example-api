package com.example.springtransactional.service;

import com.example.springtransactional.dto.FlightBookingAcknowledgement;
import com.example.springtransactional.dto.FlightBookingRequest;
import com.example.springtransactional.model.PassengerInfo;
import com.example.springtransactional.model.PaymentInfo;
import com.example.springtransactional.repository.PassengerInfoRepo;
import com.example.springtransactional.repository.PaymentRespo;
import com.example.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class FlightBookingService {
    private final PassengerInfoRepo passengerInfoRepository;
    private final PaymentRespo paymentInfoRepository;

    @Autowired
    public FlightBookingService(PassengerInfoRepo passengerInfoRepository, PaymentRespo paymentInfoRepository) {
        this.passengerInfoRepository = passengerInfoRepository;
        this.paymentInfoRepository = paymentInfoRepository;
    }

    @Transactional//(readOnly = false,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) {

        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);

    }

}
