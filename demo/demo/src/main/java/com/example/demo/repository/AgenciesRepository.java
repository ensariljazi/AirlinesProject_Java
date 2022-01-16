package com.example.demo.repository;

import com.example.demo.pojo.entity.Agencies;
import com.example.demo.pojo.entity.Customers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AgenciesRepository extends CrudRepository<Agencies, Integer> {
    List<Agencies> findAll();
    Agencies findAgenciesById(Integer id);

    @Query(
            "SELECT a FROM Agencies a "+
                    "WHERE a.agencyname= :agencyname "
    )
    List<Agencies> findAgency(@Param("agencyname") String agencyname);

}
