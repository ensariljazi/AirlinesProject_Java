package com.example.demo;

import com.example.demo.pojo.entity.Flights;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DestinationTest {

    @Test
    public void testNAME() throws DestinationExeption {
        Flights flights = new Flights(5,"123654","Milano, Italy",-1,"01.01.2022");


        assertEquals("Milano, Italy",flights.getDestination());

    }

}
