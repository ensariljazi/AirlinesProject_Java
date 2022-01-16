package com.example.demo.service;

import com.example.demo.pojo.entity.Employees;
import com.example.demo.pojo.input.EmployeesInput;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DefaultEmployeeService implements EmployeeService {


        @Autowired
        private EmployeeRepository employeesRepository;


        @Override
        public List<Employees> findAll() {
            return employeesRepository.findAll();
        }


        @Override
        public Employees findEmployeeById(Integer id) {
            if (id == null) {
                return null;
            }
            return employeesRepository.findEmployeeById(id);
        }

        @Override
        public List<Employees> findEmployeeByName(String name)
        {
            return employeesRepository.findEmployeesByName(name);
        }

    @Override
    public List<Employees> findEmployeeByAge(Integer age) {
        return employeesRepository.findEmployeesByAge(age);
    }


    @Override
        public Employees save( EmployeesInput employeesInput) {
            String name = employeesInput.getName();
            String surname = employeesInput.getSurname();
            String emgb = employeesInput.getEMBG();
            Employees employees = new Employees();
            employees.setName(name);
            employees.setSurname(surname);
            employees.setEmbg(emgb);
            return employeesRepository.save(employees);
        }

        @Override
        public Employees update(Integer id, EmployeesInput employeesInput) {
            Employees employees= employeesRepository.findEmployeeById(id);
            if (employees== null)
            {
                return null;
            }
            String updatedName = employeesInput.getName();
            String updatedSurname = employeesInput.getSurname();
            String updatedEMBG = employeesInput.getEMBG();

            employees.setName(updatedName);
            employees.setSurname(updatedSurname);
            employeesInput.setEMBG(updatedEMBG);

            return employeesRepository.save(employees);
        }

        @Override
        public void delete(Integer id) {

            employeesRepository.deleteById(id);
        }
    }


