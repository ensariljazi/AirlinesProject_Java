package com.example.demo;

import com.example.demo.pojo.entity.Agencies;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneNumberTest {
    @Test
    public void testNAME() throws NumberFormatExeption {
        Agencies agencies = new Agencies(5,"Fibula","38970205441","Skopje");


        assertEquals("38970205441",agencies.getAgencyumber());


    }

}
