package com.example.demo.controller;

import com.example.demo.repository.FlightSpendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class FlightSpendsController {

    @Autowired
    private FlightSpendsRepository flightSpendsRepository;

    @GetMapping("/flightspends")
    public double sumOfSpends(){
        return flightSpendsRepository.sumOfSpends();
    }
}
