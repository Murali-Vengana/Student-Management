package com.student.student_management.pojo;
 
import java.util.Date;

import java.util.List;
 
import jakarta.persistence.ElementCollection;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.Table;
 
@Entity

@Table(name = "students")

public class Student {

	@Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

	public String studentName;

	public String email;

	public String sex;

	public Date dob;

	@ElementCollection

	private List<String> hobbies;

	public Student() {

		super();

		// TODO Auto-generated constructor stub

	}
 
 
	public Student(String studentName, String email, String sex, Date dob, List<String> hobbies) {

		super();

		this.studentName = studentName;

		this.email = email;

		this.sex = sex;

		this.dob = dob;

		this.hobbies = hobbies;

	}
 
 
	public List<String> getHobbies() {

		return hobbies;

	}
 
 
	public void setHobbies(List<String> hobbies) {

		this.hobbies = hobbies;

	}
 
 
	public String getStudentName() {

		return studentName;

	}
 
 
	public void setStudentName(String studentName) {

		this.studentName = studentName;

	}
 
 
	public String getEmail() {

		return email;

	}
 
 
	public void setEmail(String email) {

		this.email = email;

	}
 
 
	public String getSex() {

		return sex;

	}
 
 
	public void setSex(String sex) {

		this.sex = sex;

	}
 
 
	public Date getDob() {

		return dob;

	}
 
 
	public void setDob(Date dob) {

		this.dob = dob;

	}
 
 
 
 
	


}

 