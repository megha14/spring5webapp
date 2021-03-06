# Spring Framework 5 Sample Application

This repository is for an example application built during completion of [Spring Framework 5 - Beginner to Guru](https://courses.springframework.guru/p/spring-framework-5-begginer-to-guru) online course

The application is a simple Spring Boot 2 / Spring Framework 5 web application.

The link to Udemy Spring Framework 5 Online course [here.](https://courses.springframework.guru/p/spring-framework-5-begginer-to-guru)

## Objectives of this application

Learning the following concepts -
  * JPA Entities using @Entity annotation
  * @id, @GeneratedValue annotation to uniquely identify books and authors
  * @ManyToMany to specify the many to many relationship between books and authors
  * Hibernate
  * H2
  * CommandLineRunner interface - 
     1. Functional Interface with a run method
     2. Indicates that a bean should run when it is contained within a SpringApplication. 
     3. Multiple CommandLineRunner beans can be defined within the same application context and can be ordered using the Ordered interface or @Order annotation.
     4. provides access to application arguments as string array
  * Spring MVC  
  * ThymeLeaf
     
## Common errors encountered while developing the application

1. Adding relationships to Publisher and Book entities

  org.hibernate.TransientPropertyValueException: object references an unsaved transient instance - save the transient instance before flushing : guru.springframework.spring5webapp.model.Book.publisher -> guru.springframework.spring5webapp.model.Publisher
  
  Reason - bookRepository.save(jee) was trying to save book which was accessing a publisher object not present in the database. 
  Resolution - Saving the publisher using publisherRepository.save(publisher) after initializing publisher 


