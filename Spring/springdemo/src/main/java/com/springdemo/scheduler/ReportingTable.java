//package com.springdemo.scheduler;
//
//import java.sql.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import lombok.Data;
//
//@Table
//@Entity
//@Data
//public class ReportingTable {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private int repoTableid;
//
//	private String taskName;
//
//	@CreationTimestamp
//	@Column(name = "startTime", nullable = false, updatable = true)
//	private Date startTime;
//
//	@UpdateTimestamp
//	@Column(name = "endTime")
//	private Date endTime;
//
//	@Enumerated(EnumType.STRING)
//	private Status status;
//
//}
