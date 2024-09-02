# Medication Eligibility API

This REST API provides endpoints for retrieving questions related to medication eligibility and submitting answers to determine a customer's eligibility for medication.

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Usage](#usage)
    - [API Endpoints](#api-endpoints)
- [Documentation](#documentation)
- [Contributing](#contributing)
- [License](#license)

## Features

- Retrieve questions based on a unique journey reference
- Submit answers to questions
- Determine medication eligibility based on submitted answers

## Technologies

- Java 17
- Spring Boot
- Gradle
- SpringDoc OpenAPI for API documentation

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17 or later
- Gradle 7.0 or later

### Installation

1. Clone the repository:
   ```
   git clone https://github.com/Asakar/ConsultationService.git
   ```

2. Navigate to the project directory:
   ```
   cd ConsultationService
   ```

3. Build the project:
   ```
   ./gradlew build
   ```

4. Run the application:
   ```
   ./gradlew bootRun
   ```

The API will be available at `http://localhost:8080/api`.

## Usage

### API Endpoints

1. Get Questions:
    - Endpoint: `GET /api/questions/{journeyReference}`
    - Description: Retrieves a list of questions for a specific journey.
    - Example: `curl -X GET http://localhost:8080/api/questions/123e4567-e89b-12d3-a456-426614174000`

2. Submit Answers:
    - Endpoint: `POST /api/answers`
    - Description: Submits answers and returns eligibility status.
    - Example:
      ```
      curl -X POST http://localhost:8080/api/answers \
      -H "Content-Type: application/json" \
      -d '[{"questionId":"1","value":"false"},{"questionId":"2","value":"30"},{"questionId":"3","value":"None"}]'
      ```

## Documentation

API documentation is available via Swagger UI. After starting the application, visit:
- `http://localhost:8080/swagger-ui.html`

For the OpenAPI specification, visit:
- `http://localhost:8080/v3/api-docs` (JSON format)
- `http://localhost:8080/v3/api-docs.yaml` (YAML format)

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.
