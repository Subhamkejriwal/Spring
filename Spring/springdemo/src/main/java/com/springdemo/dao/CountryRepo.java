package com.springdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdemo.bean.Student_country;

public interface CountryRepo extends JpaRepository<Student_country, Long>{

}
