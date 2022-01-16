package com.example.demo;

import com.example.demo.pojo.entity.Flights;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketNumberTest {

    @Test
    public void TicketNumber() throws TicketNumberExeption {
        Flights flights = new Flights(5,"12345678","Antalya, Turkey",120,"13.09.2022/01:00");


        assertEquals("12345678",flights.getTicketNumber());


    }
}
