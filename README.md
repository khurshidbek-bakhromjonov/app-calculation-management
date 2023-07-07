# Calculation Management Application

The Calculation Management Application is a web-based system designed to manage calculations for employees in an 
organization. It provides functionality to create, update, and delete calculations for different types of 
calculations such as salary, pension, award, and vacation. The application also allows managing employees, 
organizations, and regions.

# Technologies Used
- Java 17
- Spring Boot 2.7.5
- Spring Data JPA
- PostgreSQL
- Lombok
- ModelMapper
- Swagger 2

# Getting Started
To get started with the Calculation Management Application, follow these steps:
- Clone the repository: `git clone git@github.com:khurshidbek-bakhromjonov/app-calculation-management.git`
- Navigate to the project directory: `cd app-calculation-management`
- Build the project: `mvn clean install`
- Run the application: `mvn spring-boot:run`
- Access the application at: `http://localhost:8080`

# API Documentation
The API documentation is available using Swagger UI. You can access the Swagger UI at: 
`http://localhost:8080/swagger-ui.html`

# Endpoints
Regions
- `POST /regions`: Create a new region.
- `GET /regions/{id}`: Get a region by its ID.
- `PUT /regions/{id}`: Update a region by its ID.
- `DELETE /regions/{id}`: Delete a region by its ID.

Organisations
- `POST /organisations`: Create a new organisation.
- `GET /organisations/{id}`: Get an organisation by its ID.
- `PUT /organisations/{id}`: Update an organisation by its ID.
- `DELETE /organisations/{id}`: Delete an organisation by its ID.

Employees
- `POST /employees`: Create a new employee.
- `GET /employees/{id}`: Get an employee by their ID.
- `PUT /employees/{id}`: Update an employee by their ID.
- `DELETE /employees/{id}`: Delete an employee by their ID.

Calculations
- `POST /calculations`: Create a new calculation.
- `GET /calculations/{id}`: Get a calculation by its ID.
- `PUT /calculations/{id}`: Update a calculation by its ID.
- `DELETE /calculations/{id}`: Delete a calculation by its ID.