package com.example.demo.service;

import com.example.demo.pojo.entity.Customers;
import com.example.demo.pojo.input.CustomersInput;

import java.util.List;

public interface CustomerService {

    List<Customers> findAll();
    Customers findCustomerById(Integer id);
    Customers save( CustomersInput customersInput);
    Customers update (Integer id,CustomersInput customersInput);
    void delete(Integer id);

    List<Customers> findCustomerByName(String name);

}
