<img width="1536" height="1024" alt="Spring Boot Student System Architecture Flow (2)" src="https://github.com/user-attachments/assets/767a1bb5-d653-41c9-860c-37fcf41eac58" />

<img width="1536" height="1024" alt="Student Management System Architecture" src="https://github.com/user-attachments/assets/ea9feb71-5fd9-4a9b-ab4a-787812f52660" />

# Student Management System — Spring Boot Backend

A Spring Boot REST API for a student management application. The backend accepts student requests from a React frontend, exposes endpoints for creating and listing students, and is configured to use MySQL through Spring Data JPA and Hibernate.

> **Note:** This README summarizes the source files in the uploaded project ZIP. The service and repository implementations were referenced by the controller but were not included in the ZIP, so persistence behavior beyond the visible code should be verified.

## Features

- REST endpoint to save a student.
- REST endpoint to retrieve all students.
- JSON request and response handling.
- Student model mapped as a JPA entity.
- MySQL database configuration.
- Cross-origin configuration for the local React development server.

## Technology Stack

- Java (the project `pom.xml` configures Java 25)
- Spring Boot
- Spring Web
- Spring Data JPA / Hibernate
- MySQL
- Maven

## Architecture

The intended request flow is:

```text
React Frontend (localhost:3000)
        |
        | HTTP request / JSON
        v
StudentController
        |
        v
StudentService
        |
        v
StudentRepository (Spring Data JPA)
        |
        v
Hibernate / JPA
        |
        v
MySQL (student_management)
```

The controller receives HTTP requests and delegates work to the service layer. The service is expected to contain application/business logic and call the repository. The repository layer is expected to perform persistence through JPA/Hibernate.

**Current source note:** `StudentService` is referenced by `StudentController`, but its implementation file and a `StudentRepository` file were not present in the uploaded ZIP. Add or restore these files to complete and verify the full persistence flow.

## API Endpoints

| Method | Endpoint | Purpose |
|---|---|---|
| `POST` | `/student/saveStudent` | Accepts a student JSON payload and returns a response from the controller. |
| `GET` | `/students/getAllStudents` | Retrieves the student list through the service layer. |

The application is configured to run on port `9090`, so the local base URL is:

```text
http://localhost:9090
```

### Example: Create a Student

Request:

```http
POST http://localhost:9090/student/saveStudent
Content-Type: application/json
```

Example JSON payload (adjust fields to match the `Student` entity):

```json
{
  "studentName": "Test Student",
  "email": "test@example.com",
  "sex": "Male",
  "dob": "2005-06-15",
  "hobbies": ["Reading", "Sports"]
}
```

## Student Entity

The `Student` JPA entity in the uploaded source defines these fields:

- `id` — generated identifier
- `studentName`
- `email`
- `sex`
- `dob`
- `hobbies` — represented as a list and mapped using `@ElementCollection`

The entity does **not** define a `course` field in the uploaded version. If the React form sends `course`, add the matching field to the entity (and any required validation/mapping) if it should be persisted.

## Project Structure

```text
src/main/java/
└── <base-package>/
    ├── StudentManagementApplication.java
    ├── controllers/
    │   └── StudentController.java
    ├── pojo/
    │   └── Student.java
    └── service/
        └── StudentService.java  # referenced by controller; source missing in ZIP

src/main/resources/
└── application.properties

pom.xml
```

The repository layer is part of the intended architecture but its source file was not included in the uploaded ZIP.

## Configuration

The `application.properties` file configures the application port, MySQL connection, and JPA/Hibernate behavior. Review these values for your local environment.

Typical settings look like:

```properties
server.port=9090

spring.datasource.url=jdbc:mysql://localhost:3306/student_management
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Use your own environment-specific database credentials. Prefer environment variables or a local untracked configuration file for secrets; do not commit real database passwords to GitHub.

## Run Locally

### Prerequisites

- A compatible JDK (Java 25 is configured in the project)
- Maven
- MySQL Server

### 1. Create the database

```sql
CREATE DATABASE student_management;
```

### 2. Configure database credentials

Update `src/main/resources/application.properties` or provide the environment variables used by your configuration.

### 3. Start the backend

From the directory containing `pom.xml`:

```bash
mvn spring-boot:run
```

The API should be available at `http://localhost:9090` if startup succeeds.

## React Integration and CORS

The controller is configured for the React development origin:

```text
http://localhost:3000
```

If the frontend runs on a different origin, update the CORS configuration accordingly. If Spring Security is added, configure CORS in the security filter chain as well.

## Current Limitations / Next Steps

- Add or restore `StudentService` implementation.
- Add `StudentRepository extends JpaRepository<Student, Long>`.
- Verify that the controller delegates to the service and that save/list operations persist and retrieve records.
- Add update and delete endpoints if full CRUD support is required.
- Add request validation and consistent error responses.
- Move database credentials out of source-controlled configuration.
- Add automated tests for controller, service, and repository behavior.

## Author

**Murali Vengana**

GitHub: [Murali-Vengana](https://github.com/Murali-Vengana)

---

This project is intended for learning and demonstrating Spring Boot REST API development with a React frontend and MySQL database.

