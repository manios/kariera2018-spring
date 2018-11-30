package com.prodyna.kariera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// curl "http://localhost:8081/students/all"
// curl "http://localhost:8081/students/search/dor"
// curl -X POST "http://localhost:8081/students/" \
// -H "Content-Type: application/json" \
// -d '{"name" : "John", "surname":"Longjohn"}'
//
// curl -X DELETE "http://localhost:8081/students/3"

//https://developer.okta.com/blog/2018/10/23/php-laravel-angular-crud-app

@SpringBootApplication
public class KarieraApplication {

	public static void main(final String[] args) {
		SpringApplication.run(KarieraApplication.class, args);
	}
}
