package com.example.demo;

import com.example.demo.pojo.entity.Employees;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgeTest {

    @Test
    public void AgeTest() throws AgeExeption {
        Employees employees=new Employees(1,"Miraxh","Hajdari","132456",21);




        assertEquals(21,employees.getAge());


    }
}
