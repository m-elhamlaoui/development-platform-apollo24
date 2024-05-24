### Development-Platform

# Apollo 24 : Space Events Web Application

Done by : [full name  @github_username]

          ETTAOUIL Oussama @Ettalissimo

          FADLI Saber @fadliSaber

          NOKRA Zakaria @Zakaria-NOKRA

          ELAFOUI Badr @BalerionGT

Supervised by :

          M. MAHMOUD EL HAMLAOUI @ELHAMLAOUI

## Table of contents

1. General Context
2. Conception and analysis
   2.1. Requirements Gathering
   2.2. System Design
   2.2.1. Microservices Architecture
   2.2.2. Class Diagram
   2.2.3. Design Patterns
   2.3. Technologies Used
3. Realization
   3.1. Development
   3.2. Integration
   3.3. Testing
   3.4. Deployment
   3.5. Monitoring
4. Conclusion


## General Context

Welcome to the Space Events Web Application! This project is designed for space enthusiasts who are keen to stay updated on the latest space events. Our application fetches data from an external API, providing real-time information on space-related events. Users can subscribe to their favorite events and receive notifications whenever there are updates, ensuring they never miss any important information.

## Conception and Analysis


The development of the Space Events Web Application followed a structured approach to ensure scalability, maintainability, and user satisfaction. Here's an overview of the process:

### Requirements Gathering

- User Needs: Understand the needs of space enthusiasts to provide timely and accurate updates on space events.
    
- API Integration: Identify and integrate with reliable external APIs that provide comprehensive space event data.

- Notification System: Develop a robust notification system to inform users about updates.

### System Design

#### Microservices Architecture: 

Adopt a microservices architecture to allow independent development, testing, and deployment of different components.

![Screenshot from 2024-05-23 22-24-14](https://github.com/m-elhamlaoui/development-platform-apollo24/assets/123819933/d03ef9d2-8c1b-4bbf-a968-22377b25c574)

#### Class Diagram

![d_class](https://github.com/m-elhamlaoui/development-platform-apollo24/assets/123819933/3d6ad499-25fb-40f4-8d7a-47eec061a52b)

#### Design Patterns :

- Model-View-Controller (MVC) Pattern

The MVC pattern divides the application into three interconnected components, promoting separation of concerns and making the codebase more manageable and scalable.

- Strategy Pattern

One of the design patterns that we used is strategy pattern in the service layer of the event microservice

![Screenshot from 2024-05-23 22-48-36](https://github.com/m-elhamlaoui/development-platform-apollo24/assets/123819933/40896899-d006-4e89-b2b9-12195b4c3055)

### Technologies Used

- Backend: Java, Spring Boot
    
- Frontend: React 
    
- Database: PostgreSQL / MongoDB
    
- External API: [Launch Library 2] https://lldev.thespacedevs.com/docs/
        
- DevOps: Docker, Kubernetes, Kafka, Eureka, Grafana ...
    
## Realization

The realization phase involved the actual development and deployment of the application. Here's a step-by-step breakdown:

![Screenshot from 2024-05-23 22-28-37](https://github.com/m-elhamlaoui/development-platform-apollo24/assets/123819933/bfd963fc-8f5e-49b6-9f26-a4371570e87f)

### Development

1- Setup Development Environment: Configure the development environment with necessary tools and dependencies.
    
2- Microservices Implementation:

Event Service: Fetches and processes data from the external API.
        
User Service: Manages user registrations, logins, and subscriptions.
        
Notification Service: Sends notifications to users about event updates.
    
3- Frontend Development: Design and develop the user interface to display events and manage subscriptions.
    
4- Database Setup: Create database schemas and integrate with the backend services.

### Integration

1- API Integration: Connect the Event Service to the external API and ensure data is correctly fetched and displayed.
    
2- Inter-Service Communication (Synchrone messages): Ensure smooth communication between microservices using RESTful APIs 

3- Inter-Service Communication (Asynchrone messages): Using messaging queues {Kafka}

### Testing

Unit Testing: Write and execute unit tests for individual components.

### Deployment

Containerization: Use Docker to containerize microservices for consistent environments across development, testing, and production.
    
Orchestration: Deploy and manage containers using Kubernetes.

### Monitoring 

Prometheus: Used for collecting and storing metrics about the application’s performance. Prometheus scrapes metrics from instrumented jobs, stores them, and makes them available for querying.
    
Grafana: Provides a powerful and beautiful dashboard for visualizing metrics collected by Prometheus. Grafana helps in creating alerts, and detailed visual reports to monitor the health and performance of the application.

## Conclusion

The Space Events Web Application leverages modern technologies and best practices to deliver a reliable and engaging platform for space enthusiasts. With its microservices architecture, robust notification system, and user-friendly interface, it ensures users stay informed about the latest space events efficiently and effectively.
