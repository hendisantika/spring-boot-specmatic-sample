# Spring Boot Specmatic Sample

[![Java CI with Maven](https://github.com/hendisantika/spring-boot-specmatic-sample/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/spring-boot-specmatic-sample/actions/workflows/maven.yml)
![Java](https://img.shields.io/badge/Java-25-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.2-brightgreen)

A sample Spring Boot application demonstrating the use of [Specmatic](https://specmatic.in/) for contract testing. This
project implements a simple order management system with products and orders APIs.

## Technologies Used

- Java 25
- Spring Boot 4.1.2 (Spring Framework 7, Spring Security 7)
- Kotlin 2.4.21
- Jackson 3 (with `jackson-module-kotlin`)
- Specmatic 2.55.3
- Spring Security
- Spring Web
- Springdoc OpenAPI 2.8.13
- JUnit 6
- JaCoCo for code coverage
- Docker (Amazon Corretto 25 Alpine)

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

- Java 25 or higher
- Maven 3.9+ (or use the bundled Maven Wrapper `./mvnw`)
- Git (Specmatic clones the contract repository at test time)
- Docker (optional, for containerization)

### Building the Application

```bash
./mvnw clean package
```

This compiles the code, runs the Specmatic contract tests and produces the JaCoCo report in `target/site/jacoco`.

### Running the Application

```bash
java -jar target/specmatic-sample-0.0.1-SNAPSHOT.jar
```

Or using Spring Boot Maven plugin:

```bash
./mvnw spring-boot:run
```

Swagger UI is available at `http://localhost:8080/swagger-ui` and the OpenAPI document at
`http://localhost:8080/v3/api-doc`.

### Running with Docker

Build the JAR first, then build the Docker image:

```bash
./mvnw clean package
docker build -t spring-boot-specmatic-sample .
```

Run the Docker container:

```bash
docker run -p 8080:8080 spring-boot-specmatic-sample
```

The Dockerfile copies `target/specmatic-sample-0.0.1-SNAPSHOT.jar` into an `amazoncorretto:25-alpine` image.

## Contract Testing

This project uses Specmatic for contract testing. The contract is defined in the `specmatic.yaml` file, which references
the `api_order_v4.yaml` contract from the
[specmatic-order-contracts](https://github.com/specmatic/specmatic-order-contracts) Git repository.

To run the contract tests:

```bash
./mvnw test
```

Specmatic clones the contract repository into `.specmatic/` (git-ignored) and writes its reports to
`build/reports/specmatic` (HTML report in `build/reports/specmatic/test/html`). The build fails if API coverage drops below
70%.

## CI/CD

The [GitHub Actions workflow](.github/workflows/maven.yml) runs on every push and pull request to `main`:

- **build** - sets up Temurin JDK 25, runs `./mvnw clean package` (compile + contract tests + JaCoCo), submits the
  Maven dependency graph (on push), and uploads the JaCoCo report, the Specmatic HTML report and the JAR as artifacts.
- **docker** - builds a multi-platform (`linux/amd64`, `linux/arm64`) image. It is pushed to Docker Hub only on `main`
  when the `SPECMATIC_DOCKER_HUB_USERNAME` variable and `SPECMATIC_DOCKER_HUB_TOKEN` secret are configured.
- The Specmatic Insights build reporter runs only when the `SPECMATIC_ORG_ID` secret is configured.

## Dependency Updates

[Dependabot](.github/dependabot.yml) checks daily (05:00 Asia/Jakarta) for updates to:

- **Maven** dependencies, grouped into `spring`, `kotlin`, `jackson`, `testing` and `maven-plugins` pull requests.
  Major Spring Boot upgrades are ignored because they need manual migration.
- **GitHub Actions**, grouped into a single pull request.
- **Docker** base image (staying on the JDK 25 line).

Commit messages follow Conventional Commits (`build(deps): ...`, `build(deps-dev): ...`, `ci(deps): ...`).

## Configuration

The application can be configured using the `application.properties` file in the `src/main/resources` directory.

## License

This project is open source and available under the [MIT License](LICENSE).

## Author

- Hendi Santika
  - Email: hendisantika@yahoo.co.id
  - Telegram: @hendisantika34
  - Website: [s.id/hendisantika](https://s.id/hendisantika)
