package com.example.obspringdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObSpringdatajpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObSpringdatajpaApplication.class, args);
		CarRepository carRepository = context.getBean(CarRepository.class);

		System.out.println("The number of cars in DataBase is: " + carRepository.count());

		Car car1 = new Car(null, "Toyota", "Prius", 2012);
		carRepository.save(car1);

		System.out.println("The number of cars in DataBase is: " + carRepository.count());

		System.out.println(carRepository.findAll());

	}

}
