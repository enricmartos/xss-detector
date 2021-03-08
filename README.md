# request-validator

## Description

This REST API validates that:
- request body JSONs do not contain XSS injections
- The media type of request input files is valid

## Core technologies

*Back-end*
- Spring Boot

*Unit Testing*
- JUnit
- Mockito

*Dependency management tool*
- Maven

*Containerization*
- Docker-compose

*Documentation*
- Swagger

## Build setup

- Clone this repo to your local machine. This application can be executed either with docker or with maven wrapper:

### With Docker

```
$ docker-compose up
```

### With Maven Wrapper

```
$ sh mvnw spring-boot:run
```

- Open your browser and test the application on *http://localhost:8080/swagger-ui.html*

## Validate test scenarios

#### Scenario 1
- Given the providers defined in the table of the exercise, iterate 10 message deliveries and show the providers used for the destination 0034666111222.
- **Expected result**: Given that there are 2 providers (P1 and P3) with the prefix 0034, and they both have the same cost (1), then a random distribution is applied for these two providers. So, most likely distribution will be 5 messages sent by P1 and 5 messages by P3.

#### Scenario 2
- Given the providers defined in the table of the exercise, iterate 10 message deliveries and show the providers used for the destination 0033777111222.
- **Expected result**: Given that there is only 1 provider (P3) with this prefix 0033, P3 will send the 10 messages.

### With Swagger

- Go to message-sender-controller endpoint on *http://localhost:8080/swagger-ui.html*
- Execute the requests below and verify that the actual result matches the expected result.

### Validate file-metadata
POST http://localhost:8080/api/v1/file-metadata/validate

#### Scenario 1 (JSON with XSS injection)

**Request Body**
```json
{
  "name": "<script>alert('XSS Test')</script>Michael",
  "description": "<script>alert('XSS Test')</script>Michael"
}
```
**Expected response body** 
```json
XSS injection during JSON deserialization
```

#### Scenario 2 (JSON without XSS injection)
POST http://localhost:8080/api/v1/message/send

**Request Body**:
```json
{
  "name": "test field",
  "description": "test field"
}
```
**Expected Response body**:
```json
No XSS injection during JSON deserialization
```

### Validate file
POST http://localhost:8080/api/v1/file/validate

#### Scenario 1 (File with not allowed media type)

**Multipart form-data Body**:
```json
file: Upload a file from your system with a media type different from the ones defined in application.properties (such as "application/zip")
```
**Expected Response body**:
```json
The media type of the file is not allowed
```

#### Scenario 2 (File with allowed media type)
POST http://localhost:8080/api/v1/file/validate

**Multipart form-data Body**:
```json
file: Upload a file from your system with a media type that matches one of defined ones in application.properties (such as "application/pdf")
```
**Expected Response body**:
```json
The media type of the file is allowed
```


### With Postman

- Import [this](https://www.getpostman.com/collections/6e8d8f276d8975c5d6d7) collection and [this]() environment, which contains the requests, and the environment variables to validate the scenarios.
- Execute the 'validate file-metadata' request switching from 'xss_sample' to 'no_xss_sample' env vars
- Execute the 'validate file' request uploading a file from your system


### Unit tests

```
# Run the unit tests that cover web and service layers

$ sh mvnw test
```


