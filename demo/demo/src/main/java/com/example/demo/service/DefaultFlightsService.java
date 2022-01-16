package com.example.demo.service;

import com.example.demo.pojo.entity.Flights;
import com.example.demo.pojo.input.FlightsInput;
import com.example.demo.repository.FlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DefaultFlightsService implements FlightsService {


    @Autowired
    private FlightsRepository flightsRepository;

    @Override
    public List<Flights> findAll() {
        return flightsRepository.findAll();
    }

    @Override
    public Flights findReservationById(Integer id) {
        if (id == null) {
            return null;
        }
        return flightsRepository.findReservationsById(id);
    }

    @Override
    public Flights save(FlightsInput flightsInput) {

        String ticketNumber = flightsInput.getTicketNumber();
        String destination = flightsInput.getDestination();
        double price = flightsInput.getPrice();
        String departure = flightsInput.getDeparture();
        Flights reservations = new Flights();
        reservations.setTicketNumber(ticketNumber);
        reservations.setDestination(destination);
        reservations.setPrice(price);
        reservations.setDeparture(departure);

        return flightsRepository.save(reservations);
    }

    @Override
    public Flights update(Integer id, FlightsInput flightsInput) {
        Flights reservations = flightsRepository.findReservationsById(id);
        if(reservations==null){
            return null;
        }
        String updatedTicketNumber;
        updatedTicketNumber = flightsInput.getTicketNumber();
        String updatedDestination= flightsInput.getDestination();

        reservations.setTicketNumber(updatedTicketNumber);
        reservations.setDestination(updatedDestination);

        return flightsRepository.save(reservations);
    }

    @Override
    public void delete(Integer id) {
        flightsRepository.deleteById(id);
    }

    @Override
    public List<Flights> findReservationByDestination(String destination) {
        return flightsRepository.findReservationByDestination(destination);
    }

    @Override
    public List<Flights> findFlightByPrice(double price) {
        return  flightsRepository.findFlightByPrice(price);
    }

    @Override
    public List<Flights> findFlightByDestinationAndAgency(String destination, String agencyname) {
        return flightsRepository.findFlightByDestinationAndAgency(destination,agencyname);
    }
}

