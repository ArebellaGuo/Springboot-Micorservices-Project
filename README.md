# Springboot-Micorservices-Project

This repository contains the implementation of a Microservices-based application built using Spring Boot, Spring Cloud Netflix Eureka, Spring Cloud Gateway, Spring Cloud Config Server, Circuit Breaker, RabbitMQ and RESTful Web Services, etc. This project consists of multiple microservices that are designed around specific business capabilities.

Key features of this project:

CRUD Operations: Each microservice implements CRUD operations for managing data.
API Gateway: All services are accessible via a unified API Gateway powered by Spring Cloud Gateway.
Centralized Configuration: Spring Cloud Config and Spring Cloud Bus ensure that configuration settings are centralized and auto-refreshed across services.
Resilience: Implements Resilience4J patterns like Circuit Breaker, Retry, and RateLimiter to ensure fault tolerance.
Distributed Tracing: Spring Cloud Zipkin enable distributed tracing for debugging and monitoring microservice interactions.
API Documentation: Swagger related annotations provided for documentation and testing apis.

