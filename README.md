# Spring Boot Microservices Project
This repository contains the implementation of a Microservices-based application built using Spring Boot, Spring Cloud Netflix Eureka, Spring Cloud Gateway, Spring Cloud Config Server, Resilience4J Circuit Breaker, RabbitMQ, and RESTful Web Services.

The project demonstrates a microservice architecture where each service is designed around a specific business capability. The services are interconnected and provide a unified solution with centralized configurations and fault tolerance.

# Key Features

1. CRUD Operations
   
Each microservice implements Create, Read, Update, and Delete operations for managing data.

2. API Gateway

All microservices are accessed through a centralized API Gateway powered by Spring Cloud Gateway.

3. Centralized Configuration
   
Spring Cloud Config ensures that the configuration settings for all services are centralized.

Spring Cloud Bus enables auto-refresh of configurations across services without needing a restart.

4.  Fault Tolerance

Implemented Resilience4J patterns, including Circuit Breaker, Retry, and RateLimiter, to ensure robustness and reliability.

5.  Distributed Tracing

Spring Cloud Zipkin is used for distributed tracing, making it easier to debug and monitor microservice interactions across the system.

6. API Documentation

Swagger annotations are used for automatic API documentation and testing the REST APIs.
