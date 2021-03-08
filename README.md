# request-validator

## Description

This REST API validates that:
- Request body JSONs do not contain XSS injections
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

### With Swagger

#### Validate file-metadata
- Go to 'validate file-metadata' endpoint on *http://localhost:8080/swagger-ui.html* 
- Execute the request below and verify that the actual result matches the expected result.

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
**Expected response code** 
```json
400
```

#### Scenario 2 (JSON without XSS injection)

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
**Expected response code** 
```json
200
```

#### Validate file
- Go to 'validate file' endpoint on *http://localhost:8080/swagger-ui.html* 
- Execute the request below and verify that the actual result matches the expected result.

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
**Expected response code** 
```json
400
```

#### Scenario 2 (File with allowed media type)

**Multipart form-data Body**:
```json
file: Upload a file from your system with a media type that matches one of defined ones in application.properties (such as "application/pdf")
```
**Expected Response body**:
```json
The media type of the file is allowed
```
**Expected response code** 
```json
200
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


