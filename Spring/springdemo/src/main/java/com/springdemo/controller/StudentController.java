package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
//import com.springdemo.annotation.CityWarning;
import com.springdemo.bean.Student;
import com.springdemo.dto.StudentCountrydto;
import com.springdemo.exception.ErrorResponse;
import com.springdemo.exception.ResourceNotFoundException;
import com.springdemo.service.MyService;

@RestController
public class StudentController {

	@Autowired
	private KafkaTemplate<String, Object> template;

	private String topic = "Student";

	@Autowired
	MyService service;

	@PostMapping("/Student")
	//@CityWarning
	public Student persistStudent(@RequestBody Student student) {
		return service.persistStudent(student);
	}

	@PutMapping(path = { "/Student/{userId}" })
	public Student updateStudent(@PathVariable("userId") int userId, @RequestBody Student student) {
		StudentCountrydto studentCountrydto = new StudentCountrydto();
		Student savedData = service.getStudentById(userId);
		studentCountrydto.setName(savedData.getName());
		studentCountrydto.setMobile(savedData.getMobile());
		studentCountrydto.setUserId(savedData.getUserId());
		studentCountrydto.setPastCityWas(savedData.getCurrent_city());
		Student student2 = service.updateStudent(userId, student);
		studentCountrydto.setNewCityIs(student2.getCurrent_city());
		template.send(topic, studentCountrydto);
		return student2;
	}

	@DeleteMapping(path = { "/Student/{userId}" })
	public Student deleteStudent(@PathVariable("userId") int userId, Student student) {
		return service.deleteStudentById(userId, student);
	}

	@GetMapping(path = { "/Student" })
	public List<Student> getStudent() {
		return service.getStudent();
	}

	@GetMapping(path = { "/Student/{userId}" })
	//@CityWarning
	private ResponseEntity<?> getStudentById(@PathVariable("userId") int userId) {
		Student savedData = service.getStudentById(userId);
		ObjectMapper mapper = new ObjectMapper().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		JsonNode node = mapper.valueToTree(savedData);
		return new ResponseEntity<>(node, HttpStatus.OK);
	}

	@ExceptionHandler(value = ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorResponse handleResourceNotFoundException(ResourceNotFoundException ex) {
		return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
	}
}