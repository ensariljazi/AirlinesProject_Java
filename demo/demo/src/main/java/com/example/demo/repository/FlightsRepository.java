package com.example.demo.repository;

import com.example.demo.pojo.entity.Flights;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightsRepository extends CrudRepository<Flights, Integer> {

    List<Flights> findAll();
    Flights findReservationsById(Integer id);

    @Query(
            "SELECT r FROM Flights r "+
                    "WHERE r.destination= :destination "
    )
    List<Flights> findReservationByDestination(@Param("destination") String destination);


    @Query(
            "SELECT r FROM Flights r "+
                    "WHERE r.price= :price "
    )
    List<Flights> findFlightByPrice(@Param("price") double price);

    @Query(
            "SELECT r FROM Flights r "+
                    "Join fetch Agencies  a ON r.agencies.id= a.id "+
                    "WHERE r.destination= :destination " +
                        "AND a.agencyname= :agencyname"
    )
    List<Flights> findFlightByDestinationAndAgency(@Param("destination") String destination,
                                                   @Param("agencyname") String agencyname);
}
