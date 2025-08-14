# Week 02 – Student API (In-Memory Storage)

## Overview
This project is a **Spring Boot REST API** that manages a list of students in memory.  
It demonstrates:
- Basic CRUD operations
- DTO validation with **Jakarta Bean Validation**
- Custom exception handling for validation errors
- Returning custom HTTP response bodies

---
## Features
- **Create Student**
  - Validates fields before creation
  - Returns `201 Created` with a custom success message
- **Get Student by ID**
  - Returns the student details if found
  - Returns `404 Not Found` with a custom error body if not found
- **List All Students**
- **Delete Student by ID**
- **Custom Error Handling**
  - Validation error messages
  - Structured JSON error responses
---
## Tech Stack
- **Java 21**
- **Spring Boot 3.5.4**
- **Spring Web**
- **Jakarta Validation** (`@NotNull`, `@Size`, etc.)
- **Maven**
- **Lombok** (optional, reduces boilerplate like getters/setters and constructors)

---

## Getting Started

### 1. Prerequisites
Make sure you have installed:
- Java 21 → `java -version`
- Maven → `mvn -v`
- IntelliJ IDEA (or any Java IDE)
- Git

---

### 2. Clone Repository
```bash
git clone https://github.com/ndinh575/spring-boot-learning-path.git
cd spring-boot-learning-path/week-02-student-api-inmemory
```
---

### 3. Add `application.properties`
Create file `application.properties` in `src/main/resources`

For this project, we’ll set the application name and change the server port:

```properties
spring.application.name=week-02-student-api-inmemory
server.port=8080
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
2. Locate Week02StudentApiInmemoryApplication.java.
3. Right-click → Run.

Once running, open:

http://localhost:8080/api/students

---
### 5. API Endpoints

### Create Student
- URL
```http
POST /students
```
- Sample Success Object
```json
{
    "name": "John",
    "age": 20,
    "email": "john@example.com"
}
```
- Success Response

```json
{
  "status": 201,
  "message": "Student created successfully",
  "data": {
    "id": 1,
    "name": "John",
    "age": 20,
    "email": "john@example.com"
  }
}
```
- Sample Fail Object
```json
{
    "name": "J",
    "age": 20,
    "email": "john@example.com"
}
```

- Fail Response

```json
{
  "status": 400,
  "message": "Validation Failed",
  "detail": "Name must be at least 2 characters"
}
```
### Get List of Students
- URL
```http
GET /students
```
- Response (If the list is not empty)

```json
{
  "status": 200,
  "message": "Get list of students successfully",
  "data": [
    {
      "id": 1,
      "name": "John",
      "age": 20,
      "email": "john@example.com"
    }
  ]
}
```

- Response (If the list is empty)

```json
{
  "status": 200,
  "message": "List of students is empty",
  "data": []
}
```
### Update Student
- URL
```http
PUT /students/{id}
```
- Sample Success Object
```json
{
    "name": "Leona",
    "age": 20,
    "email": "john@example.com"
}
```
- Success Response (There's a student whose id equals 1)

```json
{
  "status": 200,
  "message": "Student updated successfully",
  "data": {
    "id": 1,
    "name": "Leona",
    "age": 20,
    "email": "john@example.com"
  }
}
```

- Fail Response (There isn't any student whose id equals 1)

```json
{
  "status": 404,
  "message": "Student not found"
}
```
### Delete Student
- URL
```http
DELETE /students/{id}
```

- Success Response (There's a student whose id equals 1)

```json
{
  "status": 200,
  "message": "Student deleted successfully"
}
```

- Fail Response (There isn't any student whose id equals 1)

```json
{
  "status": 404,
  "message": "Student not found"
}
```
---
### 6. What I Learned

- How to create RESTful endpoints with `@RestController`.

- How to use @Valid and Jakarta Bean Validation (`@NotNull`, `@Size`, etc.).

- How to build a custom Global Exception Handler with `@ControllerAdvice` and `@ExceptionHandler`.

- How to customize JSON error responses to include status, message and detail.

- How to use ResponseEntity for flexible response handling.

- How to store and manage data in-memory using List.
