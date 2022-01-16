package com.example.demo.repository;

import com.example.demo.pojo.entity.Customers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customers, Integer> {

    List<Customers> findAll();
    Customers findCustomerById(Integer id);

    @Query(
        "SELECT c FROM Customers c "+
                "WHERE c.name= :name "
    )
    List<Customers> findCustomerByName(@Param("name") String name);

    /*
    @Query(
            "SELECT SUM (price) "+
                    "FROM Flights "+
                    "WHERE id= :id "
    )
    List<Customers> toPay(@Param("customerID") Integer id);
*/
}