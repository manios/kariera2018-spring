package com.prodyna.kariera.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prodyna.kariera.dto.ActionStatusDTO;
import com.prodyna.kariera.dto.StudentDTO;
import com.prodyna.kariera.service.StudentService;

@Controller
@RequestMapping(path = "/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/hello", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody StudentDTO getHelloStudent() {

		return new StudentDTO(1L, "Charis", "Chairetouras");
	}

	@RequestMapping(value = "/all", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<StudentDTO> getAllStudents() {

		return this.studentService.getStudents();
	}

	@RequestMapping(value = "/", produces = "application/json", consumes = "application/json",
			method = RequestMethod.POST)
	public @ResponseBody ActionStatusDTO addStudent(@RequestBody final StudentDTO student) {

		this.studentService.addStudent(student);

		return new ActionStatusDTO();
	}

	@RequestMapping(value = "/{studentId}", produces = "application/json", method = RequestMethod.DELETE)
	public @ResponseBody ActionStatusDTO removeStudent(@PathVariable(value = "studentId") final Long studentId) {

		if (studentId == null) {
			return new ActionStatusDTO().signalError("Student id cannot be null");
		}

		this.studentService.removeStudent(studentId);

		return new ActionStatusDTO();
	}

	@GetMapping("/search/{term}")
	public @ResponseBody List<StudentDTO> searchStudents(@PathVariable(value = "term") final String searchTerm) {

		if (StringUtils.isEmpty(searchTerm)) {
			return new ArrayList<StudentDTO>();
		}

		return this.studentService.searchStudents(searchTerm);

	}

}
