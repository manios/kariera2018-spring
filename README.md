A Spring Boot application which can be used as a backend of Student Angular application.

It was developed as a tutorial of Spring Boot and Angular for workshop puproses on [Devs Kariera 2018 day in Athens](https://devs.kariera.gr/developers-day-december-2018/), Greece (2018-12-01).

## Database

In order to run this application you have to create a new MySQL database and ```student``` table using the following DDL commands:

```sql
CREATE SCHEMA `kariera` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `kariera`.`student` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NULL,
    `surname` VARCHAR(255) NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

```

## App configuration

Before running the application, please configure database in ```application.properties``` file accordingly:

```conf
spring.datasource.url=jdbc:mysql://myip:3306/kariera?useSSL=false
spring.datasource.username=myuser
spring.datasource.password=mypassword
```

## Run the application using an IDE

The easiest way to run is through an IDE such as Netbeans, Eclipse, IntelliJ IDEA. For example to run on Eclipse STS (Spring Tool Suite) you can import the project as a Maven project and then right click on the project and select: ```Run As```>```Spring Boot App```.

## Compile using Maven

Alternatively to the IDE, providing that you have [Maven](http://maven.apache.org/) installed, open a shell (or command prompt) and run ```mvn clean package```. An executable ```.jar``` file will be generated in ```target``` directory. Example: ```kariera2018-0.0.1-SNAPSHOT.jar```

## Run the application from shell

Run ```java -jar kariera2018-spring-0.0.1-SNAPSHOT.jar```.

The application will be available in:
* http: http://localhost:8081

You can copy and alter ```application.properties``` file in order to customize the application.

## Test the API

To test the REST API the easier way is use [cURL](https://curl.haxx.se/) or [Postman](https://www.getpostman.com/). Current examples are provided using ```curl```.

### Insert a student

Execute in a shell:

```shell
curl -X POST "http://localhost:8081/students/" \
    -H "Content-Type: application/json" \
    -d '{"name" : "John", "surname":"Longjohn"}'
```

### Return all students

Execute in a shell:

```shell
curl "http://localhost:8081/students/all"
```

### Delete a student by its id

To delete student with id:3, execute in a shell:

```shell
curl -X DELETE "http://localhost:8081/students/3"
```

### Search students with a string

To search for students with a "nik" string inside their name or surname, execute in a shell:

```shell
curl -X GET "http://localhost:8081/students/search/nik"
```
