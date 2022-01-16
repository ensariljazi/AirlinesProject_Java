package com.example.demo;

import com.example.demo.pojo.entity.Bank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardNumberTest {
    @Test
    public void CardNumber() throws CardNumberExeption {
        Bank account=new Bank(1,"1234512345123456","235","VISA");



        assertEquals("1234512345123456",account.getCardNumber());


    }
}
