package com.example.demo.pojo.entity;

import com.example.demo.CCVnumberExeption;
import com.example.demo.CardNumberExeption;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "bank")

public class Bank {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "cardnumber")
    private String cardNumber;



    @Column(name = "ccv")
    private String ccv;

    @Column(name  = "balance")
    private double balance;
    @Column(name = "type")
    private String type;


    @ManyToOne
    @JoinColumn(name="costumerID")
    @JsonBackReference
   private Customers customers;

    public Bank() {

    }
    public Bank( double balance, String cardNumber, String ccv,String type) {

        this.balance = balance;
        this.cardNumber = cardNumber;
        this.ccv = ccv;
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public void CCVnumber(String ccv) throws CCVnumberExeption {
        if((ccv.length()!=3)||(!ccv.equals(getCcv()))){
            throw new CCVnumberExeption();
        }
    }

    public void CardNumber(String cardNumber) throws CardNumberExeption {
        if((cardNumber.length()<16)||(!cardNumber.contains(getCardNumber()))){
            throw new CardNumberExeption();
        }
    }

}
