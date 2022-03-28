package com.example.springtransactional.controller;

import com.example.springtransactional.dto.FlightBookingAcknowledgement;
import com.example.springtransactional.dto.FlightBookingRequest;
import com.example.springtransactional.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightBookingController {

    @Autowired
    private FlightBookingService service;

    @PostMapping("/book")
    public FlightBookingAcknowledgement ticketBook(@RequestBody FlightBookingRequest request) {
        return service.bookFlightTicket(request);
    }

}
