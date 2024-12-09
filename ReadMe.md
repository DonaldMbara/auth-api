# Authentication API

This is a standalone **Authentication API** built with **Spring Boot** to handle user authentication and authorization. It supports **user registration**, **login**, **JWT token issuance**, and **token validation**. The API can be integrated with multiple client applications for centralized authentication.

---

## Features

- **User Registration**: Register new users securely.
- **User Login**: Authenticate users and issue **JWT tokens**.
- **Token Validation**: Validate JWT tokens for secure API access.
- **Refresh Tokens**: Issue new JWT tokens using refresh tokens.
- **Role-Based Access Control** (optional): Support for role-based permissions.

---

## Technology Stack

- **Backend**: Spring Boot
- **Security**: Spring Security, JWT
- **Database**: PostgreSQL (or any supported relational database)
- **Build Tool**: Maven

---

## API Endpoints

### 1. **User Registration**
**POST** `/auth/register`  
Register a new user.

**Request Body**:
```json
{
  "username": "user123",
  "password": "securepassword",
  "email": "user@example.com"
}
