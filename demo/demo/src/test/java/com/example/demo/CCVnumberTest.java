package com.example.demo;

import com.example.demo.pojo.entity.Bank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CCVnumberTest {

    @Test
    public void CCVNumber() throws CCVnumberExeption {
        Bank account = new Bank(5,"123456789","125","VISA");


        assertEquals("125",account.getCcv());


    }

}
