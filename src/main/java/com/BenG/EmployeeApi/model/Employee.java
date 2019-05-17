/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BenG.EmployeeApi.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
/**
 *
 * @author bghalami
 */

@Entity
@Table(name="employees")
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, 
        getterVisibility=JsonAutoDetect.Visibility.NONE, 
        setterVisibility=JsonAutoDetect.Visibility.NONE)
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonProperty("ID")
    protected Long ID;
    @Column(name="firstname")
    @JsonProperty("FirstName")
    protected String FirstName;
    @Column(name="middleinitial")
    @JsonProperty("MiddleInitial")
    protected String MiddleInitial;
    @Column(name="lastname")
    @JsonProperty("LastName")
    protected String LastName;
    @Column(name="dateofbirth")
    @JsonProperty("DateOfBirth")
    @Temporal(TemporalType.DATE)
    protected Date DateOfBirth;
    @Column(name="dateofemployment")
    @JsonProperty("DateOfEmployment")
    @Temporal(TemporalType.DATE)
    protected Date DateOfEmployment;
    // Can be ACTIVE or INACTIVE
    @Column(name="status")
    @JsonProperty("Status")
    protected String status = "ACTIVE";
    
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getMiddleInitial() {
        return MiddleInitial;
    }

    public void setMiddleInitial(String MiddleInitial) {
        this.MiddleInitial = MiddleInitial;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public Date getDateOfEmployment() {
        return DateOfEmployment;
    }

    public void setDateOfEmployment(Date DateOfEmployment) {
        this.DateOfEmployment = DateOfEmployment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
