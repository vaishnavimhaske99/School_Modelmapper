# School_Modelmapper

## Overview

This Spring Boot project is designed to manage a school system with a focus on efficient data handling using ModelMapper. The application includes the core entities needed to represent a school environment, such as `Subject`, `Student`, `Standard`, and `Teacher`. The project leverages MySQL for data persistence and uses ModelMapper for seamless mapping between entity objects and Data Transfer Objects (DTOs).

## Features

## Entities

### Subject

- **id**: Unique identifier
- **name**: Name of the subject
- **standard**: Linked `Standard`
- **teacher**: Linked `Teacher`

### Student

- **id**: Unique identifier
- **name**: Name of the student
- **email**: Email address of the student
- **standard**: Linked `Standard`

### Standard

- **id**: Unique identifier
- **name**: Name of the standard
- **students**: Set of `Student` entities
- **subjects**: Set of `Subject` entities

### Teacher

- **id**: Unique identifier
- **name**: Name of the teacher
- **subjects**: Set of `Subject` entities

## DTOs

DTOs have been created for each entity to facilitate data transfer between the client and server. Use ModelMapper to convert between DTOs and entities in the service layer.

## API Endpoints

### Teachers

- **Get Teacher by ID**: `GET /teachers/{id}`
  - Retrieves a teacher by their ID.

- **Create Teacher**: `POST /teachers`
  - Creates a new teacher.

- **Update Teacher**: `PUT /teachers/{id}`
  - Updates an existing teacher by their ID.

- **Delete Teacher**: `DELETE /teachers/{id}`
  - Deletes a teacher by their ID.

### Subjects

- **Get Subject by ID**: `GET /subjects/{id}`
  - Retrieves a subject by its ID.

- **Create Subject**: `POST /subjects`
  - Creates a new subject.

- **Update Subject**: `PUT /subjects/{id}`
  - Updates an existing subject by its ID.

- **Delete Subject**: `DELETE /subjects/{id}`
  - Deletes a subject by its ID.

### Students

- **Get Student by ID**: `GET /students/{id}`
  - Retrieves a student by their ID.

- **Create Student**: `POST /students`
  - Creates a new student.

- **Update Student**: `PUT /students/{id}`
  - Updates an existing student by their ID.

- **Delete Student**: `DELETE /students/{id}`
  - Deletes a student by their ID.

### Standards

- **Get Standard by ID**: `GET /standards/{id}`
  - Retrieves a standard by its ID.

- **Create Standard**: `POST /standards`
  - Creates a new standard.

- **Update Standard**: `PUT /standards/{id}`
  - Updates an existing standard by its ID.

- **Delete Standard**: `DELETE /standards/{id}`
  - Deletes a standard by its ID.

- **Database**: MySQL is used for storing and managing application data.
- 
- **DTOs**: Data Transfer Objects are used to facilitate data exchange between the client and server, ensuring data is handled efficiently and securely.
- **ModelMapper**: Provides a flexible way to map between entity objects and DTOs, simplifying the conversion process and improving code maintainability.

- ## ModelMapper Configuration

### Overview

ModelMapper is a Java library used for object mapping. It simplifies the process of converting between different object models, such as between entity objects and Data Transfer Objects (DTOs). In this project, ModelMapper is utilized to streamline the transformation between entities and DTOs, reducing boilerplate code and improving maintainability.

### Configuration

The `ModelMapper` bean is configured in the `AppConfig` class, which is annotated with `@Configuration` to indicate that it provides Spring configuration. This class is responsible for creating and configuring the `ModelMapper` instance.

Here is the configuration code:

```java
package com.webapp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}


## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:

- Java 17 or higher
- Maven (for building and managing the project)
- MySQL (for the database)

### Installation

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd <repository-directory>
