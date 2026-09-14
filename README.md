# CRUD Spring Java

REST API for user management built with Java and Spring Boot. The project demonstrates a simple CRUD workflow with REST endpoints and JSON-based persistence.

## Tech stack

- Java 17
- Spring Boot 4
- Spring Web
- Maven
- Jackson
- JUnit 5 / Spring Boot Test

## Architecture

The application is intentionally small and easy to follow:

- `Projeto4Application` — Spring Boot entry point.
- `Routes` — REST controllers and HTTP endpoints.
- `User` — domain model returned by the API.
- `UserRequest` — request payload used for create/update operations.
- `Data` — in-memory user list with JSON file persistence in `data.json`.

## API

Base path: `/userDB`

| Method | Endpoint | Description |
| --- | --- | --- |
| GET | `/allUsers` | List all users |
| GET | `/user/{id}` | Get one user by index |
| POST | `/newUser` | Create a user |
| PATCH | `/updateUser/{id}` | Update a user |
| DELETE | `/deleteUser/{id}` | Delete a user |
| GET | `/health` | Application health check |

Example request:

```json
{
  "name": "Joao",
  "age": 20,
  "password": "example-password"
}
```

## Getting started

### Prerequisites

- JDK 17+
- Maven 3.9+ (or use the included Maven Wrapper)

### Run locally

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

On macOS/Linux:

```bash
./mvnw spring-boot:run
```

The API starts on `http://localhost:8080`.

### Build

```bash
./mvnw clean package
```

On Windows PowerShell:

```powershell
.\mvnw.cmd clean package
```

### Test

```bash
./mvnw test
```

On Windows PowerShell:

```powershell
.\mvnw.cmd test
```

## Notes

This is an educational CRUD project. Persistence is file-based rather than database-backed, and passwords are stored as plain model fields. It is not intended for production use without authentication, password hashing, validation, database persistence, and stronger error handling.

## Project goal

The project focuses on demonstrating Java fundamentals, Spring Boot REST API development, HTTP methods, request mapping, object modeling, and automated application-context testing.
