package com.springdemo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springdemo.bean.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {

	Iterable<Student> findByIsDeletedFalse();
}