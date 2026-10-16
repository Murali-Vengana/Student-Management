package com.student.student_management.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.student_management.pojo.Student;
import com.student.student_management.service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class StudentController {
	
	private final StudentService studentService;
	
    
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}


	@PostMapping("/student/saveStudent")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		System.out.println("api called");
		System.out.println(student.getStudentName());
		Student savedStudent = studentService.saveStudent(student);
		return ResponseEntity
	            .status(HttpStatus.CREATED)
	            .body(savedStudent);
	}
	@GetMapping("/students/getAllStudents")
	public List<Student> getAllStudents() {
		List<Student> allStudents = studentService.getAllStudents();
		return allStudents;
	}
	
	@PostMapping("/student/updateStudent/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable Long id) {
		System.out.println("update api called");
		student.setId(id);
		System.out.println(student.toString());
		Student savedStudent = studentService.updateStudent(student);
		return ResponseEntity
	            .status(HttpStatus.CREATED)
	            .body(savedStudent);
		
	}
	
	@DeleteMapping("/students/deleteStudent/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
	    studentService.deleteStudent(id);
	    return ResponseEntity.ok("Student deleted successfully");
	}
}
 


