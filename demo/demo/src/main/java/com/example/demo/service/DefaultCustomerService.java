package com.example.demo.service;

import com.example.demo.pojo.entity.Customers;
import com.example.demo.pojo.input.CustomersInput;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DefaultCustomerService implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customers> findAll() {
        return customerRepository.findAll();
    }


    @Override
    public Customers findCustomerById(Integer id) {
        if (id == null) {
            return null;
        }
        return customerRepository.findCustomerById(id);
    }

    @Override
    public List<Customers> findCustomerByName(String name)
    {
        return customerRepository.findCustomerByName(name);
    }


    @Override
    public Customers save( CustomersInput customersInput) {
        String name = customersInput.getName();
        String surname = customersInput.getSurname();
        String emgb = customersInput.getEMBG();
        Customers customers = new Customers();
        customers.setName(name);
        customers.setSurname(surname);
        customers.setEMBG(emgb);
        return customerRepository.save(customers);
    }

    @Override
    public Customers update(Integer id, CustomersInput customersInput) {
        Customers customer= customerRepository.findCustomerById(id);
        if (customer== null)
        {
            return null;
        }
        String updatedName = customersInput.getName();
        String updatedSurname = customersInput.getSurname();
        String updatedEMBG = customersInput.getEMBG();

        customer.setName(updatedName);
        customer.setSurname(updatedSurname);
        customer.setEMBG(updatedEMBG);

        return customerRepository.save(customer);
    }

    @Override
    public void delete(Integer id) {

        customerRepository.deleteById(id);
    }
}

