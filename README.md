# StockfolioAI Backend

## Overview

The StockfolioAI backend is a RESTful API built with **Spring Boot** that powers user authentication, asset management, and data persistence for the StockfolioAI platform. It serves as the core business logic layer between the React frontend and the database, providing secure endpoints for managing users and their investment portfolios.

The backend is designed with a layered architecture following industry best practices, making it easy to maintain, test, and scale.

---

## Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Web (REST API)**
- **Spring Data JPA**
- **MongoDB**
- **Maven**
- **BCrypt (password hashing)**
- **Render (production deployment)**

---

## Architecture

The backend follows a standard Spring Boot layered architecture:

### Layers

- **Controller Layer**
  - Handles HTTP requests and responses
  - Exposes REST endpoints
- **Service Layer**
  - Contains business logic
  - Handles validation and transformations
- **Repository Layer**
  - Interfaces with the database using Spring Data JPA
- **Model Layer**
  - Defines entities mapped to database tables

---

## Project Structure
```
src/main/java/com/package/stockfolioai
│
├── controller
│   ├── UserController.java
|   ├── PingController.java
|   ├── PredictionController.java
│   └── AssetController.java
│
├── service
│   ├── UserService.java
│   └── AssetService.java
│
├── repository
│   ├── UserRepository.java
│   └── AssetRepository.java
│
├── model
│   ├── User.java
│   └── Asset.java
│
├── PortfolioBackendApplication.java
└── WebConfig.java
```

---

## Core Features

### User Management
- User registration
- User login
- Password hashing using BCrypt
- Update user profile
- Delete user account

### Asset Management
- Add assets to a user portfolio
- Fetch assets by user ID
- Update asset quantity and buy price
- Delete assets
- Search and paginate assets (frontend-driven)

---

## API Endpoints

### User Endpoints

| Method | Endpoint | Description |
|------|---------|-------------|
| POST | `/api/users/register` | Register a new user |
| POST | `/api/users/login` | Authenticate user |
| PUT | `/api/users/update/{id}` | Update user profile |
| DELETE | `/api/users/delete/{id}` | Delete user account |

### Asset Endpoints

| Method | Endpoint | Description |
|------|---------|-------------|
| GET | `/api/assets/{userId}` | Get all assets for a user |
| POST | `/api/assets/add` | Add a new asset |
| PUT | `/api/assets/update/{id}` | Update an asset |
| DELETE | `/api/assets/delete/{id}` | Delete an asset |

---

## Password Security

Passwords are securely hashed using **BCrypt** before being stored in the database.

- Plain-text passwords are **never** stored
- Hashing is performed server-side in the service layer
- BCrypt automatically handles salting

---

## Database

### Database Type
- **MongoDB**

### Entities

#### User
- `id`
- `username`
- `email`
- `password`

#### Asset
- `id`
- `symbol`
- `quantity`
- `buyPrice`
- `userId`

---

## Running Locally

### Prerequisites

- Java 17+
- Maven
- MongoDB

### Environment Variables

Create a `.env` file or set environment variables:

```
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/stockfolio
SPRING_DATASOURCE_USERNAME=your_db_user
SPRING_DATASOURCE_PASSWORD=your_db_password
```

### Build and Run

```bash
mvn clean install
mvn spring-boot:run
```

The API will be available at:
`http://localhost:8080`

Running in Production

Deployment Platform
	•	Render

Production Configuration
	•	MongoDB is provisioned through Render
	•	Environment variables are configured in the Render dashboard
	•	The application runs as a containerized Spring Boot service

Build Command
```
mvn clean package
```

Error Handling
	•	Graceful error responses using HTTP status codes
	•	Centralized exception handling (where applicable)
	•	Validation performed in service layer

---
