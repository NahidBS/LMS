# 📚 Library Management System (LMS)

A full-stack Library Management System built with **Java**, **Spring Boot**, and **PostgreSQL**. This project helps manage books, categories, borrowing, and user interactions in a library environment.

## 🚀 Features

- ✅ Book Management (CRUD)
- ✅ Category Management (CRUD)
- 🛠️ REST APIs using Spring Boot
- 🗃️ PostgreSQL for database
- 📦 Maven-based project
- 📄 Swagger UI documentation (OpenAPI)
- 🔐 DTO usage for clean request/response
- 🧪 Built for educational and learning purposes

## 🧱 Tech Stack

- **Backend**: Java, Spring Boot, Spring Data JPA
- **Database**: PostgreSQL
- **Build Tool**: Maven
- **Documentation**: Swagger/OpenAPI

## 📂 Project Structure
   ```bash
   com.brainstation_23.LibraryManagementSystem
   ├── controller
   │ ├── BookController.java
   │ └── CategoryController.java
   ├── dto
   │ ├── BookDTO.java
   │ └── CategoryDTO.java
   ├── entity
   │ ├── Book.java
   │ └── Category.java
   ├── repository
   │ ├── BookRepository.java
   │ └── CategoryRepository.java
   ├── service
   │ ├── BookService.java
   │ └── CategoryService.java
   └── config
   └── SwaggerConfig.java


## 📦 API Endpoints

### Book
- `POST /book/create` - Add a new book
- `GET /book/list` - List all books
- `PUT /book/edit/{id}` - Update book by ID
- `DELETE /book/delete/{id}` - Delete book by ID

### Category
- `POST /category/create` - Add a new category
- `GET /category/list` - List all categories
- `PUT /category/edit/{id}` - Update category
- `DELETE /category/delete/{id}` - Delete category

## ⚙️ How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/NahidBS/LMS.git
   cd LMS
2. Create a PostgreSQL database and configure `application.properties`:
   ```bash
   spring.datasource.url=jdbc:postgresql://localhost:5432/lms_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
3. Run the project:
   From IDE: Run LibraryManagementSystemApplication.java

3.1 From terminal:
   ```bash
   ./mvnw spring-boot:run

4. Access Swagger UI at:
   ```bash
   http://localhost:8080/swagger-ui/index.html
