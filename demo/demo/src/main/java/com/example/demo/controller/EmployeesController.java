package com.example.demo.controller;

import com.example.demo.pojo.entity.Employees;
import com.example.demo.pojo.input.EmployeesInput;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EmployeesController {

        @Autowired
        private EmployeeService employeesService;

        @GetMapping("/employees")
        public List<Employees> getEmployees() {
            return employeesService.findAll();
        }

        @GetMapping("/employeesbyid/{id}")
        public Employees findEmployee(@PathVariable Integer id) {
            return employeesService.findEmployeeById(id);
        }

        @GetMapping("/employees/{name}")
        public List<Employees> findEmployees(@PathVariable String name) {
            return employeesService.findEmployeeByName(name);
        }

        @GetMapping("/employeesbyage/{age}")
        public List<Employees> findEmployeeByAge(@PathVariable Integer age){
            return employeesService.findEmployeeByAge(age);
        }

        @DeleteMapping("/employees/{id}")
        public Boolean deleteCustomers(@PathVariable Integer id) {
            employeesService.delete(id);
            return true;
        }

        @PutMapping( "/employees/{id}")
        public Employees updateEmployee(@PathVariable Integer id,
                                         @RequestBody EmployeesInput employeesInput){
            return employeesService.update(id,employeesInput);
        }
        @PostMapping("/newemployee")
        public Employees insertNewEmployee(@RequestBody EmployeesInput employeesInput) {
            return employeesService.save(employeesInput);
        }

    }

