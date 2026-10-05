package com.student.student_management.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.student_management.pojo.Student;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
	
    
	@PostMapping("/student/saveStudent")
	public String saveStudent(@RequestBody Student student) {
		System.out.println("api called");
		System.out.println(student.getStudentName());
		return "";
	}
	}
 

