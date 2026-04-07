# Java Servlet Login System

## Table of Contents
1. Overview
2. Features
3. Technologies Used
4. Database Setup
5. Project Structure
6. Setup Instructions
7. Usage
8. Demo
9. Notes
10. License

## Overview
This project is a Java Servlet-based login system demonstrating:
- User authentication with MySQL database
- Session management for logged-in users
- "Remember Me" feature using cookies
- Logout functionality
- Basic HTML frontend for login

## Features
- User login with username & password
- Session tracking across pages
- Optional "Remember Me" using cookies
- Logout functionality
- Redirects unauthorized users to login page

## Technologies Used
- Java 17+
- Jakarta Servlet API
- MySQL 8+
- HTML / CSS (Frontend)
- JDBC (Database connectivity)

## Database Setup1

1. Install MySQL and create a database:
```sql
CREATE DATABASE login_db;
USE login_db;
````

2. Create `users` table:

```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);
```

3. Insert test users:

```sql
INSERT INTO users (username, password) VALUES ('admin','admin123');
INSERT INTO users (username, password) VALUES ('user','user123');
```

# Project Structure

```
LoginProject/
├── src/
│   ├── loginServlet/LoginServlet.java
│   ├── homeServlet/HomeServlet.java
│   └── logout/LogoutServlet.java
├── WebContent/
│   ├── login.html
│   ├── home.html
└── README.md
```

# Setup Instructions

1. Clone the repository:

```bash
git clone <your-repo-link>
```

2. Add MySQL JDBC Driver to project libraries.

3. Update database credentials in `LoginServlet.java`:

```java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/login_db", "root", "<your-password>"
);
```

4. Deploy project in Apache Tomcat or any servlet container.

5. Open in browser:

```
http://localhost:8080/<project-name>/login.html
```

# Usage

1. Open login page (`login.html`)
2. Enter username & password
3. Check “Remember Me” if needed
4. Click Login
5. After successful login, you’ll be redirected to Home page
6. Click Logout to end session

# Demo

Login Page: [replace with screenshot]
Home Page after Login: [replace with screenshot]
Logout Page: [replace with screenshot]

# Notes

* Passwords are stored in plain text (for learning purposes) — use hashing in real projects
* HomeServlet uses sessions for authentication
* Cookies store username for “Remember Me” feature
* Only authorized users can access home page


