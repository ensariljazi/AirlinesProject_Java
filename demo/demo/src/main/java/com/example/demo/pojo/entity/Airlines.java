package com.example.demo.pojo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="airlines")
public class Airlines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "companyname")
    private String companyName;

    @OneToMany(mappedBy="airlines")
    @JsonManagedReference
    private List<Flights> FlightsOfTheAirline;



    public  Airlines(){}

    public Airlines(int id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
