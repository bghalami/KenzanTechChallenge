/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BenG.EmployeeApi.controller;

import com.BenG.EmployeeApi.exception.ResourceNotFoundException;
import com.BenG.EmployeeApi.exception.BadRequestException;
import com.BenG.EmployeeApi.model.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import com.BenG.EmployeeApi.repository.EmployeeRepository;
import org.springframework.http.HttpHeaders;

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
        return landingPageText();
    }
    
    @GetMapping("/api/v1/employees")
    public List<Employee> getEmployees() {
        return employeeRepository.findAllByStatus("ACTIVE");
    }
    
    @GetMapping("/api/v1/employees/{employeeId}")
    public Employee getEmployee(@PathVariable Long employeeId) {
        return employeeRepository.findById(employeeId)
                .map (employee -> {
                    return employee;
                }).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + employeeId));
    }
    
    @PostMapping("/api/v1/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        if(employee.getFirstName() == null || employee.getFirstName().isEmpty()) {
            throw new BadRequestException("Please include a FirstName{VARCHAR(30)}");}
        if(employee.getMiddleInitial() == null || employee.getMiddleInitial().isEmpty()) {
            throw new BadRequestException("Please include a MiddleInitial{CHAR(1)}");}
        if(employee.getLastName() == null || employee.getLastName().isEmpty()) {
            throw new BadRequestException("Please include a LastName{VARCHAR(30)}");}
        if(employee.getDateOfBirth() == null) {
            throw new BadRequestException("Please include a DateOfBirth{YYYY-MM-DD}");}
        if(employee.getDateOfEmployment() == null) {
            throw new BadRequestException("Please include a DateOfEmployment{YYYY-MM-DD}");}
        return (Employee) employeeRepository.save(employee);
    }
    
    @PutMapping("/api/v1/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable Long employeeId,
                                     @Valid @RequestBody Employee employeeRequest) {
        return employeeRepository.findById(employeeId)
                .map(employee -> {
                    if(employeeRequest.getFirstName() != null) {
                      employee.setFirstName(employeeRequest.getFirstName());}
                    if(employeeRequest.getMiddleInitial() != null) {
                      employee.setMiddleInitial(employeeRequest.getMiddleInitial());}
                    if(employeeRequest.getLastName() != null) {
                      employee.setLastName(employeeRequest.getLastName());}
                    if(employeeRequest.getDateOfBirth() != null) {
                      employee.setDateOfBirth(employeeRequest.getDateOfBirth());}
                    if(employeeRequest.getDateOfEmployment() != null) {
                      employee.setDateOfEmployment(employeeRequest.getDateOfEmployment());}
                    return employeeRepository.save(employee);
                }).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + employeeId));
    }
    
    @RequestMapping(method=RequestMethod.DELETE, path = "/api/v1/employees/{employeeId}")
    public Employee deleteEmployee(@PathVariable Long employeeId, @RequestHeader HttpHeaders headers) {
        if (headers.getFirst("authorization").equals("admin")) {
            return employeeRepository.findById(employeeId)
                .map(employee -> {
                    employee.setStatus("INACTIVE");
                    return employeeRepository.save(employee);
                }).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + employeeId));
        } else {
            throw new BadRequestException("I'm sorry, Dave, I'm afraid I can't do that");
        }
        
    }
    
    public String landingPageText() {
        return "<h1>Welcome to Employee API!</h1></br>Check out these NEATO endpoints!</br>"
                + "&emsp; GET: '/api/v1/employees'</br>"
                + "&emsp;&emsp; To see index of all employees with ACTIVE Status</br>"
                + "&emsp; GET: '/api/v1/employees/{id}'</br>"
                + "&emsp;&emsp; To see a specific empoloyee</br></br>"
                + "&emsp; POST: '/api/v1/employees'</br>"
                + "&emsp;&emsp; To create new employee</br>"
                + "&emsp;&emsp; Takes the following JSON</br>"
                + "&emsp;&emsp; {</br>"
                + "&emsp;&emsp; \"FirstName\": \"{VARCHAR(250)}\",</br>"
                + "&emsp;&emsp; \"MiddleInitial\":\"{CHAR(1)}\",</br>"
                + "&emsp;&emsp; \"LastName\":\"{VARCHAR(250)}\",</br>"
                + "&emsp;&emsp; \"DateOfBirth\":\"{YYYY-MM-DD}\",</br>"
                + "&emsp;&emsp; \"DateOfEmployment\":\"{YYYY-MM-DD}\"</br>"
                + "&emsp;&emsp; }</br>"
                + "&emsp; PUT: '/api/v1/employees/{id}'</br>"
                + "&emsp;&emsp; To update an employee</br>"
                + "&emsp;&emsp; Takes any JSON field included in POST statement</br>"
                + "&emsp; DELETE: '/api/v1/employees/{id}</br>"
                + "&emsp;&emsp; Doesn't ACTUALLY delete anything.</br>"
                + "&emsp;&emsp; Sets employee status to 'INACTIVE'</br>"
                + "&emsp;&emsp; Requires authorizaiton in header</br>"
                + "&emsp;&emsp; Hint, the header key is 'authorization'</br>"
                + "&emsp;&emsp; And the correct value is 'admin'";
    }
}
