package com.example.demo.service;

import com.example.demo.pojo.entity.Employees;
import com.example.demo.pojo.input.EmployeesInput;

import java.util.List;

public interface EmployeeService {

        List<Employees> findAll();
        Employees findEmployeeById(Integer id);
        Employees save( EmployeesInput employeesInput);
        Employees update (Integer id,EmployeesInput employeesInput);
        void delete(Integer id);

        List<Employees> findEmployeeByName(String name);
        List <Employees> findEmployeeByAge(Integer age);

    }
    
