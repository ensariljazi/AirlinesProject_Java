package com.example.demo.repository;

import com.example.demo.pojo.entity.FlightSpends;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightSpendsRepository extends CrudRepository<FlightSpends, Integer> {

    @Query(
            "SELECT SUM(e.price) from Flights e"
    )
    double sumOfSpends();
}
