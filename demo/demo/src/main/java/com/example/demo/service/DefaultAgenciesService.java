package com.example.demo.service;

import com.example.demo.pojo.entity.Agencies;
import com.example.demo.repository.AgenciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultAgenciesService  implements AgenciesService{
    @Autowired
    public AgenciesRepository agenciesRepository;
    @Override
    public List<Agencies> findAll() {
        return agenciesRepository.findAll();
    }

    @Override
    public Agencies findAgenciesById(Integer id) {
        return agenciesRepository.findAgenciesById(id);
    }

    @Override
    public List<Agencies> findAgency(String name) {
        return agenciesRepository.findAgency(name);
    }
}
