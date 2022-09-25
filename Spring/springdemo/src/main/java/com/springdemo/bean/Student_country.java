package com.springdemo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "studentCountry")
public class Student_country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int countryId;
	private String country;

//	@OneToMany(mappedBy = "studentCountry")
//	private Collection<Student> student;
//}
}