/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BenG.EmployeeApi.controller;

import com.BenG.EmployeeApi.exception.ResourceNotFoundException;
import com.BenG.EmployeeApi.model.Employee;
import com.BenG.EmployeeApi.repository.EmployeeApiRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 *
 * @author bghalami
 */

@RestController
public class EmployeeApiController {
    
    @Autowired
    private EmployeeApiRepository employeeApiRepository;
    
    @GetMapping("/")
    public String root(String arg) {
        return "Welcome to Employee API!";
    }
    
    @GetMapping("/api/v1/employees")
    public List<Employee> getEmployees() {
        return employeeApiRepository.findAll();
    }
    
    @GetMapping("/api/v1/employees/{employeeId}")
    public Optional<Employee> getEmployee(@PathVariable Long employeeId) {
        return employeeApiRepository.findById(employeeId);
    }
    
    @PostMapping("/api/v1/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return (Employee) employeeApiRepository.save(employee);
    }
}
