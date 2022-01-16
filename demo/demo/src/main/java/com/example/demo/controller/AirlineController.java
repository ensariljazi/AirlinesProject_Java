package com.example.demo.controller;

import com.example.demo.pojo.entity.Airlines;
import com.example.demo.pojo.entity.Bank;
import com.example.demo.repository.AirlineRepository;
import com.example.demo.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class AirlineController {


        @Autowired
        private AirlineRepository airlineRepository;
        @GetMapping("/airlines")
        public List<Airlines> findAll(){
            return airlineRepository.findAll();
        }
        @GetMapping("/airlines/{id}")
        public Airlines findAirlinesById(@PathVariable Integer id){
            return airlineRepository.findAirlinesById(id);
        }
    }
