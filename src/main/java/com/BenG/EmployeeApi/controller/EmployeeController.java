/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BenG.EmployeeApi.controller;

import com.BenG.EmployeeApi.exception.ResourceNotFoundException;
import com.BenG.EmployeeApi.model.Employee;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import com.BenG.EmployeeApi.repository.EmployeeRepository;

/**
 *
 * @author bghalami
 */

@RestController
public class EmployeeController {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @GetMapping("/")
    public String root(String arg) {
        return "Welcome to Employee API!";
    }
    
    @GetMapping("/api/v1/employees")
    public List<Employee> getEmployees() {
        return employeeRepository.findAllByStatus("ACTIVE");
    }
    
    @GetMapping("/api/v1/employees/{employeeId}")
    public Optional<Employee> getEmployee(@PathVariable Long employeeId) {
        return employeeRepository.findById(employeeId);
    }
    
    @PostMapping("/api/v1/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return (Employee) employeeRepository.save(employee);
    }
    
    @PutMapping("/api/v1/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable Long employeeId,
                                     @Valid @RequestBody Employee employeeRequest) {
        return employeeRepository.findById(employeeId)
                .map(employee -> {
                    if(employeeRequest.getFirstName() != null) {
                      employee.setFirstName(employeeRequest.getFirstName());
                    }
                    if(employeeRequest.getMiddleInitial() != null) {
                      employee.setMiddleInitial(employeeRequest.getMiddleInitial());
                    }
                    if(employeeRequest.getLastName() != null) {
                      employee.setFirstName(employeeRequest.getLastName());
                    }
                    if(employeeRequest.getDateOfBirth() != null) {
                      employee.setDateOfBirth(employeeRequest.getDateOfBirth());
                    }
                    if(employeeRequest.getDateOfEmployment() != null) {
                      employee.setDateOfEmployment(employeeRequest.getDateOfEmployment());
                    }
                    if(employeeRequest.getStatus() != null) {
                      employee.setStatus(employeeRequest.getStatus());
                    }
                    return employeeRepository.save(employee);
                }).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + employeeId));
    }
    
    @DeleteMapping("/api/v1/employees/{employeeId}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long employeeId) {
        return employeeRepository.findById(employeeId)
                .map(employee -> {
                    employee.setStatus("INACTIVE");
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + employeeId));
    }
}
