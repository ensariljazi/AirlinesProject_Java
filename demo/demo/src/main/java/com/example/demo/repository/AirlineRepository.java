package com.example.demo.repository;

import com.example.demo.pojo.entity.Airlines;
import com.example.demo.pojo.entity.Bank;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AirlineRepository extends CrudRepository<Airlines,Integer> {
    List<Airlines> findAll();

    Airlines findAirlinesById(Integer id);

}