package com.cognizant.spring_data_jpa_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.spring_data_jpa_demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}