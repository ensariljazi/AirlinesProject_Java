package com.example.demo.pojo.entity;

import com.example.demo.EMBGnumberEception;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.naming.NameNotFoundException;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "embg")
    private String EMBG;

    @Column (name= "to_pay")
    private double toPay;




    @OneToMany(mappedBy="customers")
    @JsonManagedReference
    private List<Bank> BankCards;

    @OneToMany(mappedBy="customers")
    @JsonManagedReference
    private List<Flights> BookedFlights;

    public Customers() {
    }

    public Customers(Integer id, String name, String surname, String EMBG,double toPay) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.EMBG = EMBG;
        this.toPay=toPay;
    }

    public double getToPay() {
        return toPay;
    }

    public void setToPay(double toPay) {
        this.toPay = toPay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEMBG() {
        return EMBG;
    }

    public void setEMBG(String EMBG) {
        this.EMBG = EMBG;
    }

    public void ndrim(String emer) throws NameNotFoundException {
        if(emer != name){
            throw new NameNotFoundException();
        }
    }
    public void EMBGNumber(String embg) throws EMBGnumberEception {
        if((embg.length()!=13)||(!embg.equals(getEMBG()))){
            throw new EMBGnumberEception();
        }
    }
}
