# User Authentication and Management API

This project provides a RESTful API for user authentication and management. It supports features such as user registration, login, profile management, role management, and password updates. The API is built with Spring Boot, Spring Security, and Spring Data JPA. The API is documented using OpenAPI/Swagger for easy integration and understanding.

## Features

- **User Authentication:**
  - User registration (`/api/v1/auth/register`)
  - User login (`/api/v1/auth/login`)
  - JWT token-based authentication
- **User Management:**
  - Create, read, update, and delete user profiles (`/api/v1/user`)
  - Add or remove roles to/from a user (`/api/v1/user/addrole/{id}`, `/api/v1/user/removerole/{id}`)
  - Update user password (`/api/v1/user/updatepassword/{id}`)
- **Role Management:**
  - Assign and remove roles from users
- **Open API**
  - Testing API & Documentation (`http://localhost:8080/swagger-ui/index.html`)

## Technologies Used

- **Spring Boot** - The framework used to create the application.
- **Spring Security** - To handle user authentication and authorization.
- **Spring Data JPA** - For ORM-based database interactions.
- **H2 Database** - An in-memory database for demo purposes (can be replaced with other databases like PostgreSQL or MySQL).
- **JWT** - For securing the API and handling user authentication via tokens.
- **Swagger/OpenAPI** - For automatic API documentation.
- **AOP (Aspect-Oriented Programming)** - For handling user login attempts and account lockouts.

## Setup and Installation

### Prerequisites

Before running the project, ensure that you have the following tools installed:

- **Java 17** or higher
- **Maven** or **Gradle** (depending on the build tool you prefer)
- **IDE** (like IntelliJ IDEA, Eclipse, or VS Code)

### Clone the Repository

```bash
git clone https://github.com/Thescattypotty/UserRegistrationApi.git
cd user-authentication-management-api
mvn spring-boot:run