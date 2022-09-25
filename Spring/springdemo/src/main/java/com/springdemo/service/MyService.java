package com.springdemo.service;

import java.util.List;

import com.springdemo.bean.Student;

public interface MyService {

	public Student persistStudent(Student student);
	public List<Student> getStudent();
	public Student getStudentById(int userId);
	public Student deleteStudentById(int userId, Student student);
	public Student updateStudent(int userId, Student student);
}
