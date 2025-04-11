package com.udemy.Udemyjpa.controller;

import com.udemy.Udemyjpa.entiy.Student;
import com.udemy.Udemyjpa.response.StudentResponse;
import com.udemy.Udemyjpa.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
//@Slf4j
public class Studentcontroller {

   Logger logger= LoggerFactory.getLogger(Studentcontroller.class);


    @Autowired
    StudentService studentService;

    @Value("${app.name:default Demo App }")
    private String appName;



    //@GetMapping("/get")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public StudentResponse getStudent() {
      //  logger.info("interct beofe apo");
        StudentResponse studentResponse = new StudentResponse(1, "vikash", "Roy");
       // logger.info("interact after aop");
        return studentResponse;
    }

    @GetMapping("/all")
    public List<Student> getAllStudent() {
        logger.error("inside error");
        logger.warn("inside warn");
        logger.info("inside info");
        logger.debug("inside debug");
        logger.trace("inside trace");
        return studentService.getAllStudent();


    }

    @PostMapping("create")
    public void createStudent( @RequestBody Student student) {
        studentService.createStudent(student);

    }

    @PutMapping("update/{id}")
    public Student updateStudent(@PathVariable long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);


    }

    @DeleteMapping("delete/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
       // logger.info("inside error");

    }

    @GetMapping("getByFirstName/{firstName}")
    public Student getByFirstName(@PathVariable String firstName) {
        return studentService.getByFirstName(firstName);

    }

    @GetMapping("/{firstName}/{lastName}")
    public Student getByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName) {
        return studentService.getByFirstNameAndLastName(firstName, lastName);

    }

    @GetMapping("get/{firstName}/{lastName}")
    public List<Student> getByFirstNameOrLastName(@PathVariable String firstName, @PathVariable String lastName) {
        return studentService.getByFirstNameOrLastName(firstName,lastName);
    }

    @GetMapping("getAllWithPagination")
    public List<Student> getAllStudentWithPagination(@RequestParam int pageN0, @RequestParam int pageSize) {
        return studentService.getAllStudentWithPagination(pageN0, pageSize);

    }

    @GetMapping("sorting")
    public List<Student> getAllStudentWithSorting() {
        return studentService.getAllStudentWithSorting();
    }

    @GetMapping("like/{firstName}")
    public List<Student> like(@PathVariable String firstName) {
        return studentService.like(firstName);
    }

    @GetMapping("startWith/{firstName}")
    public List<Student> startWith(@PathVariable String firstName) {
        return studentService.startWith(firstName);

    }
    @PutMapping("updatefirstName/{id}/{firstName}")
    public Integer updateFirstNameJpql(@PathVariable long id,@PathVariable String firstName){
        return studentService.updateFirstNameJpql(id,firstName);

    }
    @DeleteMapping("deleteMap/{firstName}")
    public Integer deleteStudentMap(@PathVariable String firstName){

       return studentService.delteStudentMap(firstName);
    }
}


