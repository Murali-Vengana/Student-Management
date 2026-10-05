package com.student.student_management.pojo;
 
import java.util.Date;
 
public class Student {

	public String studentName;

	public String email;

	public String sex;

	public Date dob;

	public String[] hobbies;


	public Student(String studentName, String email, String sex, Date dob, String[] hobbies) {

		super();

		this.studentName = studentName;

		this.email = email;

		this.sex = sex;

		this.dob = dob;

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
 
 
	public String[] getHobbies() {

		return hobbies;

	}
 
 
	public void setHobbies(String[] hobbies) {

		this.hobbies = hobbies;

	}
 
 
	


}

 