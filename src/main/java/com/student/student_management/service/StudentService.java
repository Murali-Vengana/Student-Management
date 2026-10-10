package com.student.student_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.student_management.pojo.Student;
import com.student.student_management.repository.StudentRepository;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
 
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
		
				}

}
