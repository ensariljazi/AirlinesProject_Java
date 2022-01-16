package com.example.demo.repository;

import com.example.demo.pojo.entity.Employees;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository  extends CrudRepository<Employees, Integer> {

        List<Employees> findAll();

        Employees findEmployeeById(Integer id);

    @Query(
            "SELECT e FROM Employees e "+
                    "WHERE e.name= :name "
    )
    List<Employees> findEmployeesByName(@Param("name") String name);

    @Query(
            "SELECT e FROM Employees e "+
                    "WHERE e.age= :age "
    )
    List<Employees> findEmployeesByAge(@Param("age") Integer age);
    }

