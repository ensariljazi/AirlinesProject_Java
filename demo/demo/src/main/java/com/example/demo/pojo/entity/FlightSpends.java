package com.example.demo.pojo.entity;

import javax.persistence.*;

@Entity
@Table(name="flightspends")
public class FlightSpends {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "numberofflights")
    private int numberOfFlights;

    @Column(name = "sumofspends")
    private double spends;



    public FlightSpends() {
    }

    public FlightSpends(int id, int numberOfFlights, double spends) {
        this.id = id;
        this.numberOfFlights = numberOfFlights;
        this.spends = spends;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfFlights() {
        return numberOfFlights;
    }

    public void setNumberOfFlights(int numberOfFlights) {
        this.numberOfFlights = numberOfFlights;
    }

    public double getSpends() {
        return spends;
    }

    public void setSpends(double spends) {
        this.spends = spends;
    }
}
