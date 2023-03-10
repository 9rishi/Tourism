package com.rishi.tourist.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishi.tourist.dao.StudentRepository;
import com.rishi.tourist.model.Student;

@Service
public class StudentService {
	//
	@Autowired
	StudentRepository studentRepository;

	public Student saveStudent(@Valid Student student) {
		return studentRepository.save(student);
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

}
