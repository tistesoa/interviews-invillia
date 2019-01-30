# interviews-invillia
Project specific to Invillia interviews recruitment challenge.


##Database configuration
This project use H2 as database. 
Follow the database specification:

```properties
spring.datasource.url=jdbc:h2:file:~/test <br>
spring.datasource.username=sa<br> 
spring.datasource.password=<br>
spring.datasource.driver-class-name=org.h2.Driver<br>
```



###Things to be done:
1 - Create a sequence generator for each table. <br>
2 - Create a converter for LocalDateTime to String on rest response<br>
3 - Create a converter for Currency  to String or number 