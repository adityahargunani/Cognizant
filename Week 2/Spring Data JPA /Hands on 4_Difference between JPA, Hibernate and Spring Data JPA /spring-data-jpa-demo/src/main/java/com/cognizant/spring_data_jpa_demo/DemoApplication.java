package com.cognizant.spring_data_jpa_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.spring_data_jpa_demo.entity.Employee;
import com.cognizant.spring_data_jpa_demo.service.EmployeeService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    EmployeeService service;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Employee employee = new Employee("Aditya", 50000);

        service.addEmployee(employee);

        System.out.println("Employee Saved");

    }
}