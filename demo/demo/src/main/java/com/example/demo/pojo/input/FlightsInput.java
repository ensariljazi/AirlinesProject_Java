package com.example.demo.pojo.input;

public class FlightsInput {

    private String ticketNumber,destination,departure;
    double price;

    public FlightsInput() {
    }

    public FlightsInput(String ticketNumber, String destination, double price, String departure) {
        this.ticketNumber = ticketNumber;
        this.destination = destination;
        this.price=price;
        this.departure=departure;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }


    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
