package com.cognizant.spring_data_jpa_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.spring_data_jpa_demo.entity.Employee;
import com.cognizant.spring_data_jpa_demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Transactional
    public void addEmployee(Employee employee) {

        repository.save(employee);

    }

}