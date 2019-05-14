/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BenG.EmployeeApi.repository;

import com.BenG.EmployeeApi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author bghalami
 */
@Repository
public interface EmployeeApiRepository extends JpaRepository<Employee, Long> {
    
}
