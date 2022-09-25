package com.springdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.bean.Student;
import com.springdemo.dao.StudentRepo;
import com.springdemo.exception.ResourceNotFoundException;

@Service
public class StudentService implements MyService {

	@Autowired
	private StudentRepo dao;

	@Override
	public Student persistStudent(Student student) {
		return dao.save(student);
	}

	@Override
	public List<Student> getStudent() {
		List<Student> student = new ArrayList<Student>();
		dao.findByIsDeletedFalse().forEach(student1 -> student.add(student1));
		return student;
	}

	public Student deleteStudentById(int userId, Student student) {
		Student student1 = dao.findById(userId).get();

		if (Objects.nonNull(student.isDeleted())) {
			student1.setDeleted(true);
		}
		return dao.save(student1);
	}

	public Student updateStudent(int userId, Student student) {

		Student student1 = dao.findById(userId).get();
		if (Objects.nonNull(student.getCurrent_city()) && !"".equalsIgnoreCase(student.getCurrent_city())) {
			student1.setCurrent_city(student.getCurrent_city());
		}
		return dao.save(student1);
	}

	public Student getStudentById(int userId) {
		return dao.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User might be deleted or does not exist in db = " + userId));
	}
}