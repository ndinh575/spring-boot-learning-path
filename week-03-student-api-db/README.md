# Week 03 – Spring Boot Student Management API

## Overview
This project is a **Spring Boot REST API** for managing students. It uses:

- **Spring Data JPA** for database operations

- **Lombok** for reducing boilerplate code

- **DTO** + **Mapper** for clean object transfer

- **Custom ApiResponse** for consistent responses

---
## Features
- Create a new student
- Get student by ID (with ApiResponse)
- Update student information
- Delete student
- List all students
- Consistent response format with ApiResponse

---
## Tech Stack
- **Java 21**
- **Spring Boot 3.5.5**
- **Spring Web**
- **Jakarta Validation** (`@NotNull`, `@Size`, etc.)
- **Maven**
- **Lombok** 
- **MySQL**
- **Spring Data JPA**

---

## Getting Started

### 1. Prerequisites
Make sure you have installed:
- Java 21 → `java -version`
- Maven → `mvn -v`
- IntelliJ IDEA (or any Java IDE)
- Git
- MySQL Server 8.0
- MySQL Workbench

---

### 2. Clone Repository
```bash
git clone https://github.com/ndinh575/spring-boot-learning-path.git
cd spring-boot-learning-path/week-03-student-api-db
```
---

### 3. Add `application.properties`
Create file `application.properties` in `src/main/resources`

For this project, we’ll set the application name and change the server port:

```properties
spring.application.name=week-03-student-api-db
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/studentdb
spring.datasource.username=root
spring.datasource.password={your password}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

---
### 4. Run the Application
You can run it in two ways:
- Option 1 - Using Maven CLI:
```bash
mvn spring-boot:run
```
- Option 2 - Using IntelliJ IDEA:
1. Open the project in IntelliJ IDEA.
2. Locate Week03StudentApiDbApplication.java.
3. Right-click → Run.

Once running, open:

http://localhost:8080/api/students

---
### 5. API Endpoints
- Get list of students: 

 GET: ```http://localhost:8080/api/students```

- Get student by id: 

GET: ```http://localhost:8080/api/students/{id}```


- Create student: 

POST: ```http://localhost:8080/api/students```

- Update student by id: 

PUT: ```http://localhost:8080/api/students/{id}```

- Delete student by id: 

DELETE: ```http://localhost:8080/api/students/{id}```

---
### 6. What I Learned

- How to structure a Spring Boot project with controller, service, repository, DTO, and mapper.

- How to use Lombok (@Data, @AllArgsConstructor, @NoArgsConstructor) to reduce boilerplate.

- How to create a generic ApiResponse for consistent API outputs.

- Why using DTO + Mapper is better than directly exposing entities.
