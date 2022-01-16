# **Airline System Management**

<hr>

##Synopsis
This app is based on SpringbootApplication, to be more correctly is Maven.


This app it's all about Airline System Management, we tried our best to describe how 
Airline System Management really works, Application will involve the following instructions:

<ul>
<li>Bank accounts – where we will register the customers ( Data: Personal information’s, balance
of the card, card number and ccv)</li>
<li>We can delete customers, and search for them.</li>
<li>Searching for a flight with destination and agency. </li>
<li>The list of passengers that will fly to the mentioned destination</li>
<li> Number and the data of the flights in the entered date.
</li>
<li>We can delete and insert employees.</li>
</ul>



##Getting Started 
<hr>
<h2>Setup</h2>
<br>

<h4>Requirements</h4>
<h5>Install those software at first </h5>
<ul>
<li>IntellJ IDEA (recommended version => '2021.3') </li>
<li>Java SE Development Kit '11.0.12'.</li>
<li>Postman => where we start testing APIs. </li>
<li>XAMPP =>XAMPP is an easy to install Apache distribution containing MariaDB, PHP, and Perl.
This one we need to open our project locally.

</li>

</ul>



<hr>

### Programming Languages used
![Java](https://img.shields.io/badge/Language-Java-red)
![SQL](https://img.shields.io/badge/Language-SQL-red)

<hr>

###Installations
Once you clone this project from github or download it in zip, then you need to unzip and open it, in your editor IntelliJ IDEA (make sure
you click on TrustProject also after that let IntelliJ IDEA to install dependencies that we need
to open and run.
<hr>

### Technologies and APIs

![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white)    <p>Postman is an API platform for building and using APIs. Postman simplifies each step of the API lifecycle and streamlines collaboration so you can create better APIs—faster.</p>  <br>  
![XAMPP](https://img.shields.io/badge/Xampp-F37623?style=for-the-badge&logo=xampp&logoColor=white)  <p>XAMPP is an abbreviation for cross-platform, and it allows you to build projects with API's offline, on a local web server on your computer. </p>

<hr>


##Starting the application
1.First thing you have to do for running the project is to turn on APACHE SERVER AND MYSQL on XAMPP, then
they will take ports that they need.

2.[Project.sql](https://www.mediafire.com/file/iacw1kh3j731ofz/javaproject.sql/file)
=> this is the link of database, this one you need to import on your database.
('localhost/phpmyadmin').

3.also you need to check 'application.properties', for 
example ...



```properties
server.port=8080
spring.datasource.driverClassName=com.mysql.jdbc.Driver
spring.jpa.hibernate.ddl-auto=none
spring.datasource.url=jdbc:mysql://localhost:3306/seeu
spring.datasource.username=root
#Add password as environment variable

spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

#AND ALSO CHECK IF PORST ARE THE SAME, DATABASE NAME
#USERNAME AND PASSWORD.
```
### Dependencies
```xml
<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
		</dependency>
	</dependencies>
```
###Customer Endpoints 

This controller, is mapped with customerService, and also service is mapped with CustomerRepository.
where Repository makes the connection with database.
This Endpoint will find all our customer list that exists on our database on phpmyadmin.

```java
@GetMapping("/customers")
    public List<Customers> getCustomers() {
        return customerService.findAll();
    }

```


<hr>


The same thing happens to this, This one Endpoint will find our customer by name.
where we need to put the name Customer that we want to call, but here because of relationships, we
will have more data than we actually called for, cause is the foreign key, between our tables.


```java
@GetMapping("/customer/{name}")
public List<Customers> findCustomers(@PathVariable String name){
        return customerService.findCustomerByName(name);
        }
```
```json
[
    {
        "id": 2,
        "name": "Jasin",
        "surname": "Etemi",
        "BankCards": [
            {
                "cardNumber": "1427812631289736",
                "ccv": "123",
                "balance": 100.0,
                "type": "Visa"
            }
        ],
        "BookedFlights": [
            {
                "id": 1,
                "destination": "Skopje",
                "ticketNumber": "12345",
                "price": 100.0,
                "departure": "02.02.2022 / 22:05"
            },
            {
                "id": 4,
                "destination": "Milano, Italy",
                "ticketNumber": "72181",
                "price": 44.99,
                "departure": "11.03.2022 / 1:00"
            }
        ],
        "embg": "12443"
    }
]
```

<hr>

This one will delete the Customer, by the id that we will give in @PathVariable.

```java
 @DeleteMapping("/customer/{id}")
public Boolean deleteCustomers(@PathVariable Integer id) {
        customerService.delete(id);
        return true;
        }
        //this one will return true if the customer with id in @pathvariable will exists in our database
        //and this one will be deleted.
```
<hr>
This endpoint it's about to update our customer by id, we put id and then gives the data to
         request body in JSON format.

```java
@PutMapping( "/customer/{id}")
public Customers updateCustomers(@PathVariable Integer id,
@RequestBody CustomersInput customersInput){
return customerService.update(id,customersInput);
//this endpoint its about to update our customer by id, we put id and then gives the data to
        // request body in JSON format.
}
```
<hr>

This one will insertNewCustomer, but this time it needs to send the 
data including @RequestBody, where this one will wait for data in JSON format.
```java

 @PostMapping("/customer")
    public Customers insertNewCustomer(@RequestBody CustomersInput customersInput) {
        return customerService.save(customersInput);
    }
    // This other Endpoint will InsertNewCustomer, but by giving data(Name,Surname).
```



###Bank Endpoints

Endpoint with path '/bank' is same like Customer the connection between Repositories and Service.
But in bank we cannot have the customer data, because of relationship Many-To-One, that allows customer
to take bank's data but in otherwise cannot happen in bank.

```java
 @GetMapping("/bank")
    public List<Bank> findAll(){
        return bankRepository.findAll();
        //will show to us all Banks.
    }

```


<hr>

Shows the data only for bank, without including customers.

```json
[
    {
        "cardNumber": "1427812631289736",
        "ccv": "123",
        "balance": 100.0,
        "type": "Visa"
    },
    {
        "cardNumber": "21312541251231623",
        "ccv": "213",
        "balance": 100.0,
        "type": "Debit"
    },
    {
        "cardNumber": "12312453215321324",
        "ccv": "123",
        "balance": 4123.0,
        "type": "MasterCale"
    },
```
<hr>

###Flights Endpoints

This one will find us, all reservations in our database.

```java
@GetMapping("/flights")
    public List<Flights> getReservations() {
        return reservationsService.findAll();
    }
    //findAll() 

```
TESTING APIs => findAll();
```json
[
        {
        "id": 1,
        "destination": "Skopje",
        "ticketNumber": "12345",
        "price": 100.0,
        "departure": "02.02.2022 / 22:05"
        },
        {
        "id": 4,
        "destination": "Milano, Italy",
        "ticketNumber": "72181",
        "price": 44.99,
        "departure": "11.03.2022 / 1:00"
        }
]
```
<hr>

This endpoint will search for flights, but this time with destination.

```java
    @GetMapping("/flights/{destination}")
public List <Flights> findReservations(@PathVariable String destination) {
        return reservationsService.findReservationByDestination(destination);
        }
```
<hr>

'http://localhost:8080/flights/Skopje'
```json
[
{
"id": 1,
"destination": "Skopje",
"ticketNumber": "12345",
"price": 100.0,
"departure": "02.02.2022 / 22:05"
}
]
```
<hr>

This endpoint will search for prices, that we want to know.

```java

@GetMapping("/flightsbyprice/{price}")
public  List<Flights> getFlightByPrice(@PathVariable double price){
return reservationsService.findFlightByPrice(price);
}
```
<hr>

Postman Test => http://localhost:8080/flightsbyprice/100

```json
[
{
"id": 1,
"destination": "Skopje",
"ticketNumber": "12345",
"price": 100.0,
"departure": "02.02.2022 / 22:05"
}
]
```
<hr>
In this Endpoint also we can check the destination(name),

and from which agency is
that flight.

```java
 @GetMapping("/flightsto/{destination}/fromagency/{agencyname}")
    public  List<Flights> getFlightByDestinationAndAgency(@PathVariable String destination,
                                                          @PathVariable String agencyname){
        return reservationsService.findFlightByDestinationAndAgency(destination,agencyname);
    }
    


```
<hr>

After Testing => http://localhost:8080/flightsto/Skopje/fromagency/Fibula
This one will search for flights with destination 'Skopje' and also 
from which agency is realized that flight.
```json

[
    {
        "id": 1,
        "destination": "Skopje",
        "ticketNumber": "12345",
        "price": 100.0,
        "departure": "02.02.2022 / 22:05"
    }
]

```
<hr>

This Endpoint will delete flight, put we need to put which id we need to delete.
And if it founds the flight successfully, it returns true.

```java
@DeleteMapping("/flights/{id}")
    public Boolean deleteReservations(@PathVariable Integer id) {
        Flights reservations = reservationsService.findReservationById(id);
        if (reservations != null) {
            reservationsService.delete(id);
        }

        return true;
    }



```
<hr>

###Agencies Endpoints
This /agenices Endpoint , will find us all Agencies, the example will
be showed below.




```java
   @GetMapping("/agencies")
    public List<Agencies> getAgencies() {
        return agenciesService.findAll();
    }
```
</hr>
This is the postman example, where we see that Agencies Table, is connected, 
with Employees and flights, and shows combination of data between those tables.


```json
[
  {
    "id": 1,
    "agencyname": "Fibula",
    "agencyumber": "+38970123124",
    "location": "Skopje",
    "Agency_Flights": [
      {
        "id": 1,
        "destination": "Skopje",
        "ticketNumber": "12345",
        "price": 100.0,
        "departure": "02.02.2022 / 22:05"
      },
      {
        "id": 4,
        "destination": "Milano, Italy",
        "ticketNumber": "72181",
        "price": 44.99,
        "departure": "11.03.2022 / 1:00"
      }
    ],
    "employees": [
      {
        "id": 1,
        "name": "Besim",
        "surname": "Gashi",
        "embg": "123456"
      }
    ]
  },
  {
    "id": 2,
    "agencyname": "Sava Tours",
    "agencyumber": "+38972718193",
    "location": "Gostivar",
    "Agency_Flights": [
      {
        "id": 5,
        "destination": "Dubai, Saudi Arabia",
        "ticketNumber": "231811",
        "price": 44.0,
        "departure": "30.03.2022 / 3:00"
      }
    ],
    "employees": [
      {
        "id": 3,
        "name": "Miraxh",
        "surname": "Lika",
        "embg": "569856"
      }
    ]
  },
  {
    "id": 3,
    "agencyname": "ETC",
    "agencyumber": "+38975555191",
    "location": "Skopje",
    "Agency_Flights": [
      {
        "id": 6,
        "destination": "Antalya, Turkey",
        "ticketNumber": "12312",
        "price": 88.0,
        "departure": "13.09.2021 / 2:00"
      }
    ],
    "employees": [
      {
        "id": 4,
        "name": "Julia",
        "surname": "Bobna",
        "embg": "659874"
      }
    ]
  }
]

```
<hr>

This one will show to us the agency with required id.
```java
    @GetMapping("/agencybyid/{id}")
     public Agencies findAgencies(@PathVariable Integer id) {
         return agenciesService.findAgenciesById(id);
     }

```
<hr>


=> http://localhost:8080/agencybyid/1
also once again i will tell that, here we call for agencyid, and also 
get flights, and employees.
```json
{
    "id": 1,
    "agencyname": "Fibula",
    "agencyumber": "+38970123124",
    "location": "Skopje",
    "Agency_Flights": [
        {
            "id": 1,
            "destination": "Skopje",
            "ticketNumber": "12345",
            "price": 100.0,
            "departure": "02.02.2022 / 22:05"
        },
        {
            "id": 4,
            "destination": "Milano, Italy",
            "ticketNumber": "72181",
            "price": 44.99,
            "departure": "11.03.2022 / 1:00"
        }
    ],
    "employees": [
        {
            "id": 1,
            "name": "Besim",
            "surname": "Gashi",
            "embg": "123456"
        }
    ]
}
```
<hr>

###Airline Endpoints

This endpoint, will take all airlines, in this table, we have companyname, and id.

```java
  @GetMapping("/airlines")
        public List<Airlines> findAll(){
            return airlineRepository.findAll();
        }
```

<hr>

Here we have the test off the APIs with path = > http://localhost:8080/airlines
here is shown company name, and the flights that this company is part of.
```json
[
    {
        "id": 1,
        "companyName": "WizzAir",
        "FlightsOfTheAirline": [
            {
                "id": 1,
                "destination": "Skopje",
                "ticketNumber": "12345",
                "price": 100.0,
                "departure": "02.02.2022 / 22:05"
            },
            {
                "id": 5,
                "destination": "Dubai, Saudi Arabia",
                "ticketNumber": "231811",
                "price": 44.0,
                "departure": "30.03.2022 / 3:00"
            }
        ]
    },
    {
        "id": 2,
        "companyName": "TurkishAirlines",
        "FlightsOfTheAirline": [
            {
                "id": 6,
                "destination": "Antalya, Turkey",
                "ticketNumber": "12312",
                "price": 88.0,
                "departure": "13.09.2021 / 2:00"
            }
        ]
    },
    {
        "id": 3,
        "companyName": "FlyEmirates",
        "FlightsOfTheAirline": []
    },
    {
        "id": 4,
        "companyName": "FlyQatar",
        "FlightsOfTheAirline": []
    },
    {
        "id": 5,
        "companyName": "FlyDubai",
        "FlightsOfTheAirline": [
            {
                "id": 4,
                "destination": "Milano, Italy",
                "ticketNumber": "72181",
                "price": 44.99,
                "departure": "11.03.2022 / 1:00"
            }
        ]
    }
]


```
<hr>

In this endpoint we will be able to search by the airlinesid.

```java
 @GetMapping("/airlines/{id}")
        public Airlines findAirlinesById(@PathVariable Integer id){
            return airlineRepository.findAirlinesById(id);
        }


```
Here are some result from testing the APIs.



Here we put the id of airlines that we want to see all informations.
'http://localhost:8080/airlines/1'
```json
{
    "id": 1,
    "companyName": "WizzAir",
    "FlightsOfTheAirline": [
        {
            "id": 1,
            "destination": "Skopje",
            "ticketNumber": "12345",
            "price": 100.0,
            "departure": "02.02.2022 / 22:05"
        },
        {
            "id": 5,
            "destination": "Dubai, Saudi Arabia",
            "ticketNumber": "231811",
            "price": 44.0,
            "departure": "30.03.2022 / 3:00"
        }
    ]
}
```
<hr>

###Employees Endpoints

This endpoint will show us, all employees.

```java
@GetMapping("/employees")
        public List<Employees> getEmployees() {
            return employeesService.findAll();
        }
```

<hr>

Here is the list of employees that are part of Airline System Management.
```json
[
    {
        "id": 1,
        "name": "Besim",
        "surname": "Gashi",
        "embg": "123456"
    },
    {
        "id": 3,
        "name": "Miraxh",
        "surname": "Lika",
        "embg": "569856"
    },
    {
        "id": 4,
        "name": "Julia",
        "surname": "Bobna",
        "embg": "659874"
    }
]

```
<hr>


At this Endpoint is same like those that we had above.


We search for Employess with id.

```java
@GetMapping("/employeesbyid/{id}")
        public Employees findEmployee(@PathVariable Integer id) {
            return employeesService.findEmployeeById(id);
        }


```

<hr>
Here is the example of testing the APIs.

=> http://localhost:8080/employeesbyid/1

```json
{
    "id": 1,
    "name": "Besim",
    "surname": "Gashi",
    "age": 25,
    "embg": "123456"
}


```

<hr>
We search for Employess by their age here.

```java
@GetMapping("/employeesbyage/{age}")
        public Employees findEmployee(@PathVariable Integer id) {
            return employeesService.findEmployeeById(id);
        }


```

<hr>
Here is the example of testing the APIs

=> http://localhost:8080/employeesbyage/20

```json
{
    "id": 4,
    "name": "Julia",
    "surname": "Bobna",
    "age" : 20,
    "embg": "659874"
}


```


<hr>
In this Endpoint we will be searching for employees name.


```java

@GetMapping("/employees/{name}")
        public List<Employees> findEmployees(@PathVariable String name) {
            return employeesService.findEmployeeByName(name);
        }

```
<hr>

Here is the example from Postman Test.


=> http://localhost:8080/employees/Miraxh
```json

[
  {
"id": 3,
"name": "Miraxh",
"surname": "Lika",
"age ": 21,    
"embg": "569856"
  }
]

```
<hr>

This endpoint will help us to delete employees, by puting the id on url path.
```java
@DeleteMapping("/employees/{id}")
        public Boolean deleteCustomers(@PathVariable Integer id) {
            employeesService.delete(id);
            return true;
        }
//if id is same like any employees in the table,
// then it will return true, otherwise, not found

```
<hr>
This endpoint will help us to update an existing employee, by specifying the  id.


```java
@PutMapping( "/employees/{id}")
        public Employees updateEmployee(@PathVariable Integer id,
                                         @RequestBody EmployeesInput employeesInput){
            return employeesService.update(id,employeesInput);
        }


```
=> http://localhost:8080/employees/1

I updated the employee with id 1, so Miraxh Lika, turned into  Arlinda Ajdari.


```json
{      
    "name":"Arlinda",
    "surname":"Ajdari",
    "embg":23331231
    

}

```
From Miraxh to Arlinda;

```json

{
    "id": 1,
    "name": "Arlinda",
    "surname": "Ajdari",
    "embg": "123456"


}

```
<hr>

This endpoint will allow us to insertNewEmployee

To do this we need all the attributes  gave to @RequestBody in JSON format.

```java
  @PostMapping("/newemployee")
        public Employees insertNewEmployee(@RequestBody EmployeesInput employeesInput) {
            return employeesService.save(employeesInput);
        }

```

<hr>

We put the values into RequestBody and then, insert them into database.



But here we need also to mention that Id it's not required, because its 
auto generated.


=> http://localhost:8080/newemployee
```json
{
        
        "name": "David",
        "surname": "Munday",
        "embg": "23331231"
    }


```
And then if we go for the path /employees then we will see , that this employee
its already in our database.
```json
[
  {
    "id": 1,
    "name": "Arlinda",
    "surname": "Ajdari",
    "embg": "123456"
  },
  {
    "id": 3,
    "name": "Miraxh",
    "surname": "Lika",
    "embg": "569856"
  },
  {
    "id": 4,
    "name": "Julia",
    "surname": "Bobna",
    "embg": "659874"
  },
  {
    "id": 5,
    "name": "Scott",
    "surname": "Adking",
    "embg": "23331231"
  },
  {
    "id": 6,
    "name": "David",
    "surname": "Munday",
    "embg": "23331231"
  }
]

```


###Bugs and Features Requests

 je28592@seeu.edu.mk

 mh28602@seeu.edu.mk

 ei28608@seeu.edu.mk
