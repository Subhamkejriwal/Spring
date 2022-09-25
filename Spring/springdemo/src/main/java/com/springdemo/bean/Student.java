package com.springdemo.bean;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Data
@EnableSwagger2
@Entity
@Table(name = "student", uniqueConstraints = @UniqueConstraint(columnNames = { "name", "mobile" }))
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	
	private String name;

	private String mobile;

	private String current_city;
	
	private String native_city;

	private boolean isDeleted = Boolean.FALSE;

	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updateAt;
	

	@ManyToOne(cascade = CascadeType.ALL)
	private Student_country studentCountry;
}