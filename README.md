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
	- Create an Employee, takes the following; "FirstName", "LastName","MiddleInitial", "DateOfBirth", "DateOfEmployment" 
  - None of the above fields can be empty
  - Status defaults to ACTIVE
"GET": "/api/v1/employees/:id"
	- Show single Employee; ID, FirstName, MiddleInitial, LastName, DateOfBirth, DateOfEmployment, and Status
"PUT": "/api/v1/employees/:id"
	- Changes GM info, takes any combination of the following; "FirstName", "LastName", "MiddleInitial", "DateOfBirth", "DateOfEmployment" 
 "DELETE": "/api/v1/employees/:id"
	- Sets an Employees Status to INACTIVE
  - Employee will not show up in GET by id or GET all employees
  - Employee will persist in DB
  - To use succussfully you must add an HTTP Header with the key 'authorization' and the value 'admin'
```

## Initial Setup

1. Clone the repository and rename the repository to anything you'd like in one command:
  ```shell
  git clone git@github.com:bghalami/KenzanTechChallenge.git
  ```
2. Change into the new director directory.

3. Install the dependencies:

  ```shell
  mvn clean install
  ```
  
## Running the Server Locally

To see your code in action locally, you need to fire up a development server. Use the command:

```shell
mvn spring-boot:run
```

Once the server is running, visit in your browser:

* `http://localhost:8080/` to run your application.

* The application loads up the schema-h2.sql and data-h2.sql on startup to populate the database with 8 example employees for you to toy with.


## Built With

* [Java Developer Kit 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven](https://maven.apache.org/)
* [Spring Boot](http://spring.io/projects/spring-boot)
* [JPA](https://spring.io/projects/spring-data-jpa)
* [Apache Libraries](https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/RandomStringUtils.html)
* [H2](https://www.h2database.com/html/main.html)
* And last but CERTAINLY not least, [Stack Overflow](https://stackoverflow.com/)
