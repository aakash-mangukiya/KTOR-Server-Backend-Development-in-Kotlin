# Ktor REST API Backend

This is a RESTful API backend built with Ktor, a modern and asynchronous web framework for Kotlin.

## Features

*   **RESTful API:** Provides endpoints for interacting with the application.
*   **Authentication:** Secures endpoints using JWT (JSON Web Tokens).
*   **Database Interaction:** Uses Exposed for database access.
*   **Dependency Injection:** Manages dependencies with Koin.

## Libraries Used

This project utilizes the following libraries:

| Library                               | Description                               |
| ------------------------------------- | ----------------------------------------- |
| **Ktor**                              | Asynchronous web framework for Kotlin.    |
| - `ktor-server-core`                  | Core components for the Ktor server.      |
| - `ktor-server-netty`                 | Netty engine for running the Ktor server. |
| - `ktor-serialization-kotlinx-json`   | JSON serialization support.               |
| - `ktor-server-content-negotiation`   | Content negotiation for APIs.             |
| - `ktor-server-auth`                  | Authentication support.                   |
| - `ktor-server-auth-jwt`              | JWT authentication support.               |
| - `ktor-server-config-yaml`           | YAML configuration support.               |
| **Exposed**                           | SQL framework for Kotlin.                 |
| - `exposed-core`                      | Core components for Exposed.              |
| - `exposed-jdbc`                      | JDBC driver support for Exposed.          |
| - `exposed-dao`                       | DAO (Data Access Object) API for Exposed. |
| **Koin**                              | Dependency injection framework for Kotlin.|
| - `koin-ktor`                         | Koin integration for Ktor.                |
| - `koin-logger-slf4j`                 | Logging for Koin.                         |
| **MySQL Connector/J**                 | JDBC driver for MySQL.                    |
| **jBcrypt**                           | Password hashing library.                 |
| **Logback**                           | Logging framework.                        |
| **H2 Database**                       | In-memory database for testing.           |

## Getting Started

1.  **Clone the repository:**
    ```bash
    git clone <repository-url>
    ```
2.  **Configure the application:**
    *   Open `src/main/resources/application.yaml`.
    *   Update the `database` section with your MySQL connection details (URL, user, password).
    *   Update the `jwt.secret` with a strong, unique secret.
3.  **Run the application:**
    ```bash
    ./gradlew run
    ```

The API will be available at `http://localhost:8080`.
