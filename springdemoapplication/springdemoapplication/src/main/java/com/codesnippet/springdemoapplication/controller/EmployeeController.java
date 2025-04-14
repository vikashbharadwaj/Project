package com.codesnippet.springdemoapplication.controller;

import com.codesnippet.springdemoapplication.dto.EmployeeDto;
import com.codesnippet.springdemoapplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;


    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Integer id) throws Exception {
        EmployeeDto employee = employeeService.getEmployee(id);
        throw new Exception("product order is not found");

    }

}
