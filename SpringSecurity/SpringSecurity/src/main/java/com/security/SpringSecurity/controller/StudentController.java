package com.security.SpringSecurity.controller;

import com.security.SpringSecurity.model.Student;
import jakarta.servlet.ServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student>students=new ArrayList<>(List.of(
            new Student(1,"vikas",60),
            new  Student(2,"kiran",65)



    ));

    @GetMapping("/student")
    public List<Student>getStudent(){
        return  students;

    }
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(ServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");

    }
    @PostMapping("/post")
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return  student;

    }
}
