# Ktor REST API Backend

This is a RESTful API backend built with Ktor, a modern and asynchronous web framework for Kotlin.

## Features

*   **RESTful API:** Provides endpoints for interacting with the application.
*   **Authentication:** Secures endpoints using JWT (JSON Web Tokens).
*   **Database Interaction:** Uses Exposed for database access.
*   **Dependency Injection:** Manages dependencies with Koin.

## Libraries Used

This project utilizes the following libraries:

| Library                               | Version | Description                               |
| ------------------------------------- | ------- | ----------------------------------------- |
| **Ktor**                              | 3.4.0   | Asynchronous web framework for Kotlin.    |
| - `ktor-server-core`                  | 3.4.0   | Core components for the Ktor server.      |
| - `ktor-server-netty`                 | 3.4.0   | Netty engine for running the Ktor server. |
| - `ktor-serialization-kotlinx-json`   | 3.4.0   | JSON serialization support.               |
| - `ktor-server-content-negotiation`   | 3.4.0   | Content negotiation for APIs.             |
| - `ktor-server-auth`                  | 3.4.0   | Authentication support.                   |
| - `ktor-server-auth-jwt`              | 3.4.0   | JWT authentication support.               |
| - `ktor-server-config-yaml`           | 3.4.0   | YAML configuration support.               |
| **Exposed**                           | 0.61.0  | SQL framework for Kotlin.                 |
| - `exposed-core`                      | 0.61.0  | Core components for Exposed.              |
| - `exposed-jdbc`                      | 0.61.0  | JDBC driver support for Exposed.          |
| - `exposed-dao`                       | 0.61.0  | DAO (Data Access Object) API for Exposed. |
| **Koin**                              | 4.1.1   | Dependency injection framework for Kotlin.|
| - `koin-ktor`                         | 4.1.1   | Koin integration for Ktor.                |
| - `koin-logger-slf4j`                 | 4.1.1   | Logging for Koin.                         |
| **MySQL Connector/J**                 | 8.4.0   | JDBC driver for MySQL.                    |
| **jBcrypt**                           | 0.4     | Password hashing library.                 |
| **Logback**                           | 1.4.14  | Logging framework.                        |
| **H2 Database**                       | 2.3.232 | In-memory database for testing.           |

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
