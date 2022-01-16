package com.example.demo.controller;

import com.example.demo.pojo.entity.Flights;
import com.example.demo.service.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightsController {

    @Autowired
    private FlightsService reservationsService;

    @GetMapping("/flights")
    public List<Flights> getReservations() {
        return reservationsService.findAll();
    }

    @GetMapping("/flights/{destination}")
    public List <Flights> findReservations(@PathVariable String destination) {
        return reservationsService.findReservationByDestination(destination);
    }

    @GetMapping("/flightsbyprice/{price}")
    public  List<Flights> getFlightByPrice(@PathVariable double price){
        return reservationsService.findFlightByPrice(price);
    }

    @GetMapping("/flightsto/{destination}/fromagency/{agencyname}")
    public  List<Flights> getFlightByDestinationAndAgency(@PathVariable String destination,
                                                          @PathVariable String agencyname){
        return reservationsService.findFlightByDestinationAndAgency(destination,agencyname);
    }

}



