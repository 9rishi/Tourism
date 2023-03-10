package com.rishi.tourist.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishi.tourist.model.Student;
import com.rishi.tourist.service.StudentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/student")
public class StudentController {

	//
	@Autowired
	StudentService studentService;

	@PostMapping
	public ResponseEntity<?> createStudent(@Valid @RequestBody Student student) {
		Student student1 = studentService.saveStudent(student);
		return new ResponseEntity<>(student1, HttpStatus.OK);
	}

	@GetMapping(path = "/all")
	public ResponseEntity<?> getAllStudents() {
		return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
	}
}
