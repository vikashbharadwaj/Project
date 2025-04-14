package com.codesnippet.springdemoapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController   //controller+responsebody;
public class Employeecontrol {
    @GetMapping("/get")
    public String getEmp(@RequestParam Integer empid){
        return "employee";
    }
    @PostMapping("/post")
    public String addEmp(){
        return "add";
    }
    @PutMapping("/update")
    public String updateEmp(){
        return "update";
    }
    @DeleteMapping("/delete")
    public String deleteEmp(){
        return "delete";
    }
}

