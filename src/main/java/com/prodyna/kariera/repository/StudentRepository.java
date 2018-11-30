package com.prodyna.kariera.repository;

import org.springframework.data.repository.CrudRepository;

import com.prodyna.kariera.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	// Basic CRUD is AUTO IMPLEMENTED by Spring into a Bean created during deployment.
	// CRUD refers Create, Read, Update, Delete
}
