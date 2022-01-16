package com.example.demo.service;

import com.example.demo.repository.FlightSpendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultFlightSpendsService implements FlightSpendsService {

    @Autowired
    private FlightSpendsRepository flightSpendsRepository;


    @Override
    public double sumOfSpends() {
         return flightSpendsRepository.sumOfSpends();
    }
}
