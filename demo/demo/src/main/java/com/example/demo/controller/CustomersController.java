package com.example.demo.controller;

import com.example.demo.pojo.entity.Customers;
import com.example.demo.pojo.input.CustomersInput;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customers> getCustomers() {
        return customerService.findAll();
    }

   @GetMapping("/customerbyid/{id}")
    public Customers findCustomers(@PathVariable Integer id) {
        return customerService.findCustomerById(id);
    }

    @GetMapping("/customer/{name}")
    public List<Customers> findCustomers(@PathVariable String name) {
        return customerService.findCustomerByName(name);
    }


    @DeleteMapping("/customer/{id}")
    public Boolean deleteCustomers(@PathVariable Integer id) {
        customerService.delete(id);
        return true;
    }

    @PutMapping( "/customer/{id}")
    public Customers updateCustomers(@PathVariable Integer id,
                                @RequestBody CustomersInput customersInput){
        return customerService.update(id,customersInput);
    }
    @PostMapping("/customer")
    public Customers insertNewCustomer(@RequestBody CustomersInput customersInput) {
        return customerService.save(customersInput);
    }

}
