package com.example.demo.controller;

import com.example.demo.pojo.entity.Bank;
import com.example.demo.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankController {
    @Autowired
    private BankRepository bankRepository;
    @GetMapping("/bank")
    public List<Bank> findAll(){
        return bankRepository.findAll();
    }
    @GetMapping("/bank{id}")
    public Bank findOne(@PathVariable Integer id){
        return bankRepository.findOneById(id);
    }
}
