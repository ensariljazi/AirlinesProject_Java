package com.example.demo.service;

import com.example.demo.pojo.entity.Flights;
import com.example.demo.pojo.input.FlightsInput;

import java.util.List;

public interface FlightsService {
    List<Flights> findAll();
    Flights findReservationById(Integer id);
    Flights save(FlightsInput flightsInput);
    Flights update (Integer id, FlightsInput flightsInput);
    void delete(Integer id);

    //Query Search
    List<Flights> findReservationByDestination(String destination);
    List<Flights> findFlightByPrice(double price);
    List<Flights> findFlightByDestinationAndAgency(String destination, String agencyname);
}
