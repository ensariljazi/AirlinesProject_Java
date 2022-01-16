package com.example.demo.controller;

import com.example.demo.pojo.entity.Agencies;
import com.example.demo.pojo.entity.Customers;
import com.example.demo.pojo.input.CustomersInput;
import com.example.demo.service.AgenciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgenciesController {
    @Autowired
    private AgenciesService agenciesService;

    @GetMapping("/agencies")
    public List<Agencies> getAgencies() {
        return agenciesService.findAll();
    }

    @GetMapping("/agencybyid/{id}")
     public Agencies findAgencies(@PathVariable Integer id) {
         return agenciesService.findAgenciesById(id);
     }



    @GetMapping("/agencies/{agencyname}")
    public List<Agencies> findAgenciesByName(@PathVariable String agencyname) {
        return agenciesService.findAgency(agencyname);
    }





}
