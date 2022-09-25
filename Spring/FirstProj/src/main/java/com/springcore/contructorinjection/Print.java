package com.springcore.contructorinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.collections.Emp;

public class Print {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/contructorinjection/ciconfig.xml");
		Person emp1 = (Person) context.getBean("person");
		System.out.println(emp1);

	}

}
