/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BenG.EmployeeApi.view;

/**
 *
 * @author bghalami
 */


// Probably should have just made an HTML file
public class rootString {
    public static void main(String args) {
    }
    
    public static String landingText() {
        return "<h1>Welcome to Employee API!</h1></br>Check out these NEATO endpoints!</br>"
                + "&emsp; GET: '/'</br>"
                + "&emsp;&emsp; Instructions to use the app</br>"
                + "&emsp; GET: '/api/v1/employees'</br>"
                + "&emsp;&emsp; Show all ACTIVE Employees</br>"
                + "&emsp; GET: '/api/v1/employees/{id}'</br>"
                + "&emsp;&emsp; Show single Employee</br>"
                + "&emsp;&emsp;&emsp; {</br>"
                + "&emsp;&emsp;&emsp; \"ID\": 1,</br>"
                + "&emsp;&emsp;&emsp; \"FirstName\": \"Ben\",</br>"
                + "&emsp;&emsp;&emsp; \"MiddleInitial\": \"A\",</br>"
                + "&emsp;&emsp;&emsp; \"LastName\": \"Ghalami\",</br>"
                + "&emsp;&emsp;&emsp; \"DateOfBirth\": \"1991-08-06\",</br>"
                + "&emsp;&emsp;&emsp; \"DateOfEmployment\": \"1991-08-16\",</br>"
                + "&emsp;&emsp;&emsp; \"Status\": \"ACTIVE\"</br>"
                + "&emsp;&emsp;&emsp; }</br>"
                + "&emsp; POST: '/api/v1/employees'</br>"
                + "&emsp;&emsp; To create new employee</br>"
                + "&emsp;&emsp; Takes the following JSON</br>"
                + "&emsp;&emsp; NONE of the fields can be empty </br>"
                + "&emsp;&emsp; {</br>"
                + "&emsp;&emsp; \"FirstName\": \"{VARCHAR(30)}\",</br>"
                + "&emsp;&emsp; \"MiddleInitial\":\"{CHAR(1)}\",</br>"
                + "&emsp;&emsp; \"LastName\":\"{VARCHAR(30)}\",</br>"
                + "&emsp;&emsp; \"DateOfBirth\":\"{YYYY-MM-DD}\",</br>"
                + "&emsp;&emsp; \"DateOfEmployment\":\"{YYYY-MM-DD}\"</br>"
                + "&emsp;&emsp; }</br>"
                + "&emsp;&emsp; ID will Auto-Increment and Status will default to 'ACTIVE' </br>"
                + "&emsp;&emsp; MUST include HTTP Header 'Content-Type' with value 'application/json'</br>"
                + "&emsp; PUT: '/api/v1/employees/{id}'</br>"
                + "&emsp;&emsp; To update an employee</br>"
                + "&emsp;&emsp; Changes Employee info, takes any combination of the following as JSON in the BODY:</br>"
                + "&emsp;&emsp; \"FirstName\", \"LastName\", \"MiddleInitial\", \"DateOfBirth\", \"DateOfEmployment\"</br>"
                + "&emsp;&emsp; MUST include HTTP Header 'Content-Type' with value 'application/json'</br>"
                + "&emsp; DELETE: '/api/v1/employees/{id}</br>"
                + "&emsp;&emsp; Doesn't ACTUALLY delete anything.</br>"
                + "&emsp;&emsp; Sets employee status to 'INACTIVE'</br>"
                + "&emsp;&emsp; Employee will persist in database</br>"
                + "&emsp;&emsp; To use succussfully you must add an HTTP Header with the key 'Authorization' and the value 'Admin'";
    }
}
