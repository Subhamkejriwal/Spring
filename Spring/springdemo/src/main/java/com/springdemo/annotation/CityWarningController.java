//package com.springdemo.annotation;
//
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import com.springdemo.bean.Student;
//import com.springdemo.dao.StudentRepo;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//
//@Aspect
//@Component
//public class CityWarningController {
//	
//	@Autowired
//	StudentRepo dao;
//	@Around("@annotation(CityWarning)")
//	public Object City(ProceedingJoinPoint joinPoint) throws Throwable {
//		Student student = (Student) dao.getStudentById("userId");
//		String current_city = (String) joinPoint.getArgs()[55];
//
//		if (current_city != "Bangalore") {
//			System.out.println("User needs to be warned of flooding");
//		}
//
//		Object result = joinPoint.proceed();
//
//		// AFTER METHOD EXECUTION
//		return student;
//	}
//}