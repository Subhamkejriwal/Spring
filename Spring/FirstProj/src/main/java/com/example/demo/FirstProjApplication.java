package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstProjApplication.class, args);
		
		System.out.println("Hello world");
		Alien a = new Alien();
		a.show();
	}
}
*/

/*public class FirstProjApplication
{
	private static ApplicationContext context;

	public static void main(String[] args)
	{
		System.out.println("Hello World");
	    context = new ClassPathXmlApplicationContext("config.xml");
		Alien alien1 = (Alien) context.getBean("alien1");
		
		System.out.println(alien1);
	}
}
*/

public class FirstProjApplication
{
	private static ApplicationContext context;

	public static void main(String[] args)
	{
		System.out.println("Hello World");
	    context = new ClassPathXmlApplicationContext("config.xml");
		Alien alien1 = (Alien) context.getBean("alien1");
		Alien alien2 = (Alien) context.getBean("alien2");
		
		System.out.println(alien1);
		System.out.println(alien2);
	}
}