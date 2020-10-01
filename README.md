# library-app


This project was bootstrapped with [Spring Initializr](https://start.spring.io/).


This is a Maven project that developed using Spring Boot, Spring Data JPA, Thymeleaf, Spring Security, H2 Database.

This is a library application. H2 embedded database is used as database in the application. There are books, publishers and authors records. In the application we can list them, add new records, delete and update them.



## To Run The Application
Maven must be installed on your computer to run the application from the command line.

> \>git clone https://github.com/oguzkayaya/library-app 
>
> \>cd library-app 
>
> \>mvn spring-boot:run


You can also clone and open it with an IDE such as Intellij, Eclipse

And the application works at http://localhost:8090/

<hr>

You will need to login. There are users in 2 different roles that you can login

User whose role is **ADMIN** can do all operations, Create, Delete, Update

> Username: Admin	
>
> Password: Admin123

Standard users whose role is USER cannot delete and update, they can only add.

> Username: User
>
> Password: User123
