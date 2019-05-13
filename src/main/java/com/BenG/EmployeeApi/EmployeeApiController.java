/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BenG.EmployeeApi;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author bghalami
 */
@RestController
public class EmployeeApiController {
    
    @RequestMapping("/wow")
    public String index() {
        return "We made it!";
    }
    
}
