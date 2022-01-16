package com.example.demo;

import com.example.demo.pojo.entity.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.naming.NameNotFoundException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

		Customers customers = new Customers(2,"valom","gashi","1234567891235",123.25);
		System.out.println(customers.toString());


		try {
			customers.ndrim("valom");
		} catch (NameNotFoundException e) {
			System.out.println("Wrong name entered!");
		}

		try {
			customers.EMBGNumber("1234567891235");
		} catch (EMBGnumberEception e) {
			System.out.println("Wrong EMBG number!");
		}


		Flights flights=new Flights(1,"12345678","Milano, Italy",100.0,"10.10.2022");
		System.out.println(flights.toString());

		try {
			flights.changePrice(12);
		} catch (NegativeAmountExeption negativeAmountExeption) {
			System.out.println("Negative Price!!!");
		}

		try {
			flights.changeDestination("Milano, Italy");
		} catch (DestinationExeption destinationExeption) {
			System.out.println("You cannot change the destination of the flight!!!");
		}

		try {
			flights.TicketNumberCheck("12345678");
		} catch (TicketNumberExeption ticketNumberExeption) {
			System.out.println("You have entered a wrong ticket number!!");
		}


		Agencies agencies=new Agencies(1,"Fibula","38970205441","Skopje");
		System.out.println(agencies.toString());

		try{
			agencies.PhoneNumber("38970205441");
		} catch (NumberFormatExeption numberFormatExeption) {
			System.out.println("The number should contain 389 at the beggining!");
		}


		Bank account=new Bank(1,"1234512345123456","235","VISA");
		System.out.println(account.toString());

		try{
			account.CCVnumber("235");
		} catch (CCVnumberExeption ccVnumberExeption) {
			System.out.println("You entered a wrong CCV number or more than three digits!");
		}

		try{
			account.CardNumber("1234512345123456");
		} catch (CardNumberExeption cardNumberExeption) {
			System.out.println("You entered a wrong card number or less than 20 digits!");
		}


		Employees employees=new Employees(1,"Ensar","Iljazi","123456",21);
		try{
			employees.AgeTest(18);
		} catch (AgeExeption ageExeption) {
			System.out.println("You are under 18!");
		}

	}

}
