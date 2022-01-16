package com.example.demo.service;

import com.example.demo.pojo.entity.Agencies;
import com.example.demo.pojo.entity.Customers;
import com.example.demo.pojo.input.CustomersInput;

import java.util.List;

public interface AgenciesService  {
    List<Agencies> findAll();
    Agencies findAgenciesById(Integer id);


    List<Agencies> findAgency(String name);
}
