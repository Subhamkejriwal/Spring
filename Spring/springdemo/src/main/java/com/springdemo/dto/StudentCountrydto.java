package com.springdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCountrydto {

	private int UserId;

	private String Name;

	private String Mobile;

	private String PastCityWas;

	private String newCityIs;

}