package com.example.demo;

import com.example.demo.pojo.entity.Flights;
import org.junit.jupiter.api.Test;

import javax.naming.NameNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightPriceTest {
    @Test
    public void testNAME() throws NameNotFoundException {
        Flights flights = new Flights(5,"123654","Skopje",100,"01.01.2022");


        assertEquals(100,flights.getPrice());

    }

}
