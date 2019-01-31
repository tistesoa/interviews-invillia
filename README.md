# interviews-invillia
Project specific to Invillia interviews recruitment challenge.<br>
The tasks developed is a little bit different, maybe because the description is not clear. <br>
In meantime, to create a Order and a Payment, I choose to not pass the states attribute by a request. The program will change the state when a payment or a refund is requested. 



## Server.
In this challenge, I choose to use Spring Boot Starter to not get attached to container configuration. But, in larger system in production,
I'll look up to configure and deploy to a AWS platform.   


## Database configuration
This project use H2 as database solution example. But migrate to a corporate database system like Oracle DB or PostGre, its is a best solution. In case of bigdata context, mongoDB seems to be a better alternative to database 
<br>Follow the database specification:

```properties
spring.datasource.url=jdbc:h2:file:~/test <br>
spring.datasource.username=sa<br> 
spring.datasource.password=<br>
spring.datasource.driver-class-name=org.h2.Driver<br>
```
### Security
Not using any type of security, however I would configure token based authentication (JWT) or Spring Security Authentication provider (OAuth2) to provide restrict service for customers.

### Swagger
This project is using Swagger 2. When the app is running, access the link: 
* http://localhost:8080/invillia/swagger-ui.html 

### Unit test
Unit test is very important to any application, however, provide more time to implement them.
The frameworks JUnit and Mockito could be use to this task.
 
### *Some things missing*:
1 - Create a sequence generator for each table. <br>
2 - Create a converter for LocalDateTime to String on rest response<br>
3 - Create a converter for Currency  to String or number <br>
4 - Create handlers (spring advices) for standardize exceptions messages and JSON format <br>
5 - Configure bundle messages<br>

## Non functional requirements
##### *“Speed, Scale, Agility”.*
To accomplish this three requirement, it's interesting move your application to a Cloud system. 
In a Cloud System, you can ensure availability and scalability via redundancy, by replicating you system across 
others virtual machines and use a Loud Balancer to traffic distribution. As well, it's possible to user monitoring programs to auto scaling your application when it demands. <br>
Fault tolerance, Failover solution will keep your application running when some instance or all system failure, by auto activating another "platform" until the main system back . <br>

Thus, using Spring framework, exist a lot of documentation and dependencies to deploy your Spring application to AWS Cloud, integrating easily with 
AWS messaging, AWS JDBC, AWS Context and AWS Core.     
