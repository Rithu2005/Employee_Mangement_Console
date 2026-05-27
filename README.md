# Employee Management System

A simple **Java JDBC Console Application** developed using **Core Java** and **MySQL** to perform Employee Management operations.
This project demonstrates CRUD operations with database connectivity using JDBC.

---

# Features

* Add New Employee
* View All Employees
* View Employee By ID
* Update Employee Details
* Delete Employee
* MySQL Database Connectivity
* Menu Driven Console Application

---

# Technologies Used

* Java
* JDBC
* MySQL
* VS Code / IntelliJ
* MySQL Connector JAR

---

# Database Used

```sql id="if6k7n"
Database Name : training_db
```

### Tables

* employee
* department
* project

---

# Employee Table Fields

```text id="h1g3zf"
empid
empname
emailid
mobilenumber
city
state
date_of_joining
departmentid
projectid
status
experience
```

---

# Project Workflow

1. Connect Java with MySQL using JDBC
2. Take user input using Scanner
3. Perform CRUD Operations
4. Display employee records from database
5. Handle database queries using PreparedStatement

---

# CRUD Operations Implemented

## Insert Employee

Adds employee details into database.

## View Employees

Displays all employee records.

## View Specific Employee

Search employee using Employee ID.

## Update Employee

Updates employee city using Employee ID.

## Delete Employee

Deletes employee record from database.

---

# JDBC Concepts Used

* DriverManager
* Connection
* PreparedStatement
* Statement
* ResultSet
* executeUpdate()
* executeQuery()

---

# Sample Menu

```text id="b54kvh"
1. Insert Employee
2. View All Employees
3. View Specific Employee
4. Update Employee
5. Delete Employee
6. Exit
```

---

# How To Run

## Compile

```bash id="0g99lz"
javac -cp ".;mysql-connector-j-9.7.0.jar" EmployeeConnection.java
```

## Run

```bash id="uxq74r"
java -cp ".;mysql-connector-j-9.7.0.jar" EmployeeConnection
```

---

# What I Learned

* Java Database Connectivity
* SQL CRUD Operations
* Database Design
* MySQL Integration with Java
* Handling User Inputs
* Using Prepared Statements
* Console Based Application Development

---

# Future Improvements

* GUI using Java Swing / JavaFX
* Login Authentication
* Search By Department
* Project Allocation Module
* Spring Boot Integration
* REST API Development

---

# Project Summary

This project is a beginner-friendly Employee Management System created using Java and MySQL.
It performs complete CRUD operations through JDBC connectivity and helps understand real-time database interaction using Java. The project improved my understanding of SQL queries, database handling, and Java backend development concepts.
