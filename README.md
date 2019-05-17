# Employee REST API

#### Created By Ben Ghalami

This is an API with the ability to Create, View, Delete, and Edit Employees in an In-Memory Database.

## Endpoints

```
"GET": "/"
  - Instructions on how to use app
"GET": "/api/v1/employees"
  - Show all ACTIVE Employees
"POST": "/api/v1/employees"
  - Create an Employee, takes the following; "FirstName", "LastName","MiddleInitial",  
  "DateOfBirth", "DateOfEmployment" 
  - Takes the following as JSON in the BODY
  -NONE of the fields can be empty
  -{    
  "FirstName": {VARCHAR(30)},  
  "MiddleInitial": {CHAR(1)},  
  "LastName": {VARCHAR(30)},  
  "DateOfBirth": {YYYY-MM-DD},  
  "DateOfEmployment": {YYYY-MM-DD}  
   }
  - MUST include HTTP header `Content-Type` with value `application/json`
"GET": "/api/v1/employees/:id"
  - Show single Employee; ID, FirstName, MiddleInitial, LastName, DateOfBirth, DateOfEmployment, and Status
  -{  
  "ID": 1,  
  "FirstName": "Ben",  
  "MiddleInitial": "A",  
  "LastName": "Ghalami",  
  "DateOfBirth": "1991-08-06",  
  "DateOfEmployment": "1991-08-16",  
  "Status": "ACTIVE"
   }
"PUT": "/api/v1/employees/:id"
  - Changes Employee info, takes any combination of the following as JSON in the BODY;  
"FirstName", "LastName", "MiddleInitial",  
  "DateOfBirth", "DateOfEmployment"
  - MUST include HTTP header `Content-Type` with value `application/json`
 "DELETE": "/api/v1/employees/:id"
  - Sets an Employees Status to INACTIVE
  - Employee will not show up in GET by id or GET all employees
  - Employee will persist in DB
  - To use succussfully you must add an HTTP Header with the key 'authorization' and the value 'admin'
```

## Initial Setup

1. Clone the repository into a directory of your choosing:
  ```shell
  git clone git@github.com:bghalami/KenzanTechChallenge.git
  ```
2. Navigate into the new directory.

3. Install the dependencies:

  ```shell
  mvn clean install
  ```
  
## Running the Server Locally

To see your code in action locally, you need to fire up a development server. From the root of the project  
use the command:

```shell
mvn spring-boot:run
```

Once the server is running, visit in your browser, or with [PostMan](https://www.getpostman.com/):

* `http://localhost:8080/` to run your application.

* The application uses hibernate to load up the schema-h2.sql and data-h2.sql files on startup  
to populate the database with 8 example employees for you to toy with.

* To quit the server simply press Ctrl + C to shut it down.

## Pick a design pattern, any design pattern!
#### How about MVC
As you may or may not know, Ruby on Rails was my first love. So it's no surprise I stuck with the tried and true  
MVC (Model, View, Controller) pattern. Sans View in this case.  
One of the reasons I enjoy MVC so much is because I have a personal affinity for Abstraction and Encapsulation.  
Everything lives by itself, not to be bothered unless needed. A goal I strive for in my personal life.  
I feel like the MVC most closely resembles a real world structure, which makes it easy to grasp.  
Our Model is the blueprint, the Controller is the fusebox, and the View is the lightbulb.  


## Built With

* [Java Developer Kit 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven](https://maven.apache.org/)
* [Spring Boot](http://spring.io/projects/spring-boot)
* [JPA](https://spring.io/projects/spring-data-jpa)
* [Apache Libraries](https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/RandomStringUtils.html)
* [H2](https://www.h2database.com/html/main.html)
* And last but CERTAINLY not least, [Stack Overflow](https://stackoverflow.com/)
