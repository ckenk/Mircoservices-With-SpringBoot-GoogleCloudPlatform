# Mircoservices App with Spring Boot and Google Cloud

A real world app from Coursera course ["Building Scalable Java Microservices with Spring Boot and Spring Cloud"](https://www.coursera.org/learn/google-cloud-java-spring), which demonstrates the core features of a cloud based microservices and services provided by Google Cloud - Google Cloud Platform (GCP).
 - Has 2 Spring Boot applications that communicate with wach other to provide front end and backend services. Both apps use `lombok` code generation and provides `HATEOAS` (Hypertext as the Engine of Application State) responses.
   - Frontend (guestbook-frontend): Spring Boot with Thymeleaf, FeignClient (a declarative api client)
   - Backend (guestbook-service): Spring Boot app with PagingAndSortingRepository

Added by me:
 - Extra documentation & notes explaining the features and functionality are added as comments within the code.
 - Some tests under ["guestbook-service"](https://github.com/ckenk/MircoservicesDemoSpringBoot/tree/main/guestbook-service/src/test/java/com/example/guestbook).
