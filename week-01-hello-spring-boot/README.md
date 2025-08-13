# Week 01 – Hello Spring Boot

## Overview
This is my first Spring Boot application.  
The goal of this project is to:
- Learn the basics of **Spring Boot**.
- Understand **REST API fundamentals**.
- Practice creating and running a Spring Boot project using **Spring Initializr**.

The application exposes two simple endpoints:
- `/api/hello` – Returns a greeting message.
- `/api/goodbye` – Returns a goodbye message.

---

## Tech Stack
- **Java 21**
- **Spring Boot 3.5.4**
- **Spring Web**
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
cd spring-boot-learning-path/week-01-hello-spring-boot
```
---

### 3. Add `application.properties`
Create file `application.properties` in `src/main/resources`

For this project, we’ll set the application name and change the server port:

```properties
spring.application.name=week-01-hello-spring-boot
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
2. Locate HelloSpringBootApplication.java.
3. Right-click → Run.

Once running, open:

http://localhost:8080/api/hello

http://localhost:8080/api/goodbye

---
### 5. Project Structure
```css
week-01-hello-spring-boot/
 ├─ src/
 │  ├─ main/
 │  └─ test/
 ├─ pom.xml
 └─ README.md
```

---
### 6. What I Learned
- How to create a Spring Boot project using Spring Initializr.
- `@SpringBootApplication` → Main entry point, enables auto-configuration.
- `@RestController` → Marks a class as a REST controller.
- `@RequestMapping` → Maps HTTP requests to handler methods.
- `@GetMapping` → Handles HTTP GET requests.
- `@RequestParam` → Extracts query parameters from the request.
- How to run a Spring Boot application locally and test endpoints in the browser or Postman.
