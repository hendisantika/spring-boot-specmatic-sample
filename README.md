# Spring Boot Specmatic Sample

A sample Spring Boot application demonstrating the use of [Specmatic](https://specmatic.in/) for contract testing. This
project implements a simple order management system with products and orders APIs.

## Technologies Used

- Spring Boot 3.5.3
- Kotlin 2.2.0
- Java 21
- Specmatic 2.14.3
- Spring Security
- Spring Web
- JUnit 5
- JaCoCo for code coverage
- Docker

## Features

- RESTful API for managing products and orders
- API contract testing with Specmatic
- Authentication using API keys
- Validation of request data
- Containerization with Docker

## API Endpoints

### Products API

- `POST /products` - Create a new product
- `GET /products/{id}` - Get a specific product by ID
- `POST /products/{id}` - Update a product
- `DELETE /products/{id}` - Delete a product
- `GET /products` - Search products by name, type, and/or status
- `PUT /products/{id}/image` - Upload an image for a product

### Orders API

- `POST /orders` - Create a new order
- `POST /orders/bulk` - Create multiple orders
- `GET /orders/{id}` - Get a specific order by ID
- `DELETE /orders/{id}` - Delete an order
- `POST /orders/{id}` - Update an order
- `GET /orders` - Search orders by status and/or product ID

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven
- Docker (optional, for containerization)

### Building the Application

```bash
mvn clean package
```

### Running the Application

```bash
java -jar target/specmatic-sample-0.0.1-SNAPSHOT.jar
```

Or using Spring Boot Maven plugin:

```bash
mvn spring-boot:run
```

### Running with Docker

Build the Docker image:

```bash
docker build -t spring-boot-specmatic-sample .
```

Run the Docker container:

```bash
docker run -p 8080:8080 spring-boot-specmatic-sample
```

Note: The Dockerfile expects the JAR file to be at `target/specmatic-order-api-1.0-SNAPSHOT.jar`, but the Maven build
produces `target/specmatic-sample-0.0.1-SNAPSHOT.jar`. You may need to rename the JAR file or update the Dockerfile.

## Contract Testing

This project uses Specmatic for contract testing. The contract is defined in the `specmatic.yaml` file, which references
a contract from a Git repository.

To run the contract tests:

```bash
mvn test
```

## Configuration

The application can be configured using the `application.properties` file in the `src/main/resources` directory.

## License

This project is open source and available under the [MIT License](LICENSE).

## Author

- Hendi Santika
  - Email: hendisantika@yahoo.co.id
  - Telegram: @hendisantika34
  - Website: [s.id/hendisantika](https://s.id/hendisantika)
