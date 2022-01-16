package com.example.demo;

import com.example.demo.pojo.entity.Customers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EMBGNumberTest {

    @Test
    public void EMBGTest() throws EMBGnumberEception {
        Customers customers = new Customers(5,"jasin","hajdari","1234567891234",100);


        assertEquals("1234567891234",customers.getEMBG());


    }

}
