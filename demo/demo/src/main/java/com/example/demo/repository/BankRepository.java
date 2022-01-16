package com.example.demo.repository;

import com.example.demo.pojo.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BankRepository extends CrudRepository<Bank, Integer> {
    List<Bank>findAll();
    Bank findOneById(Integer id);
}
