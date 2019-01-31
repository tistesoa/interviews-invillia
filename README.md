# interviews-invillia
Project specific to Invillia interviews recruitment challenge.



##Server.
In this challenge, I choose to use Spring Boot Starter to not get attached to container configuration. But, in larger system in production,
I'll look up deploy configuration to AWS or Google Compute Engine  


##Database configuration
This project use H2 as database. 
Follow the database specification:

```properties
spring.datasource.url=jdbc:h2:file:~/test <br>
spring.datasource.username=sa<br> 
spring.datasource.password=<br>
spring.datasource.driver-class-name=org.h2.Driver<br>
```
###Security
Not using any type of security, however I would configure token based authentication (JWT) or Spring Security Authentication provider (OAuth2)

###Swagger
When the app is running, access the link: 
* http://localhost:8080/invillia/swagger-ui.html 


###Things to be done:
1 - Create a sequence generator for each table. <br>
2 - Create a converter for LocalDateTime to String on rest response<br>
3 - Create a converter for Currency  to String or number <br>
4 - Create handlers (spring advices) for standardize exceptions messages and JSON format <br>
5 - Configure bundle messages<br>
