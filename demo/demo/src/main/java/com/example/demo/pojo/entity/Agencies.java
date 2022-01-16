package com.example.demo.pojo.entity;

import com.example.demo.NumberFormatExeption;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="agencies")
public class Agencies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="agencyname")
    private  String agencyname;

    @Column(name="agencynumber")
    private String agencyumber;

    @Column(name="location")
    private String location;

    @OneToMany(mappedBy="agencies")
    @JsonManagedReference
    private List<Flights> Agency_Flights;

    @OneToMany(mappedBy="agencies")
    @JsonManagedReference
    private List<Employees> employees;


    public Agencies(Integer id, String agencyname, String agencyumber, String location) {
        this.id = id;
        this.agencyname = agencyname;
        this.agencyumber = agencyumber;
        this.location = location;
    }

    public Agencies() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgencyname() {
        return agencyname;
    }

    public void setAgencyname(String agencyname) {
        this.agencyname = agencyname;
    }

    public String getAgencyumber() {
        return agencyumber;
    }

    public void setAgencyumber(String agencyumber) {
        this.agencyumber = agencyumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void PhoneNumber(String agencyumber) throws NumberFormatExeption {
        if(!agencyumber.contains("389")){
            throw new NumberFormatExeption();
        }
    }
}
