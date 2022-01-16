package com.example.demo.pojo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.example.demo.*;
import javax.persistence.*;

@Entity
@Table(name="flights")
public class Flights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column (name = "destination")
    private  String destination;

    @Column(name = "ticket_number")
    private String ticketNumber;

    @Column(name = "price")
    private double price;
    @Column(name="departure")
    private String departure;



    @ManyToOne
    @JoinColumn(name="reservationID")
    @JsonBackReference
    private Airlines airlines;

    /*@ManyToMany
    @JoinTable(
            name ="reservations",
            joinColumns = @JoinColumn (name ="flights_id"),
            inverseJoinColumns = @JoinColumn(name="costumers_id")
    )
    private List<Customers> customersList=new ArrayList<>();

    public void BookedFlights(Customers customers){
        customersList.add(customers);
    }
*/
    @ManyToOne
    @JoinColumn(name="bookingflightid")
    @JsonBackReference
    private Customers customers;


    @ManyToOne
    @JoinColumn(name="agencyflights")
    @JsonBackReference
    private Agencies agencies;


    public Flights(){}

    public Flights(int id, String ticketNumber, String destination, double price , String departure) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void changePrice(double price) throws NegativeAmountExeption {
        if(price < 0){
            throw new NegativeAmountExeption();

        }
    }
    public void changeDestination(String destination) throws DestinationExeption {
        if(destination != getDestination()){
            throw new DestinationExeption();
        }
    }

    public void TicketNumberCheck(String ticketNumber) throws TicketNumberExeption {
        if((ticketNumber.length()!=8)||(!ticketNumber.equals(getTicketNumber()))){
            throw new TicketNumberExeption();
        }
    }

}
