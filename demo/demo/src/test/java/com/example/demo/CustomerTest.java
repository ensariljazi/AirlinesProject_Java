package com.example.demo;
import com.example.demo.pojo.entity.Customers;
import org.junit.jupiter.api.Test;

import javax.naming.NameNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    @Test
    public void testNAME() throws NameNotFoundException {
        Customers customers = new Customers(5,"gashi","hajdari","12321231231",100);


        assertEquals("gashi",customers.getName());


    }

}