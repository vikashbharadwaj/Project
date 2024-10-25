package com.example.vikas.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.vikas.sms.entity.Student;
import com.example.vikas.sms.service.StudentService;
import com.example.vikas.sms.service.impl.StudentServiceImpl;

@Controller
public class StudentController {


private StudentService studentService;

public StudentController(StudentService studentService) {
	super();
	this.studentService = studentService;
}

// handler method to handle list students and return mode and view
@GetMapping("/students")
public String listStudents(Model model) {
	model.addAttribute("students", studentService.getAllStudent());
	return "students";
}

@GetMapping("/students/new")
public String createStudentForm(Model model) {
	
	// create student object to hold student form data
	Student student = new Student();
	model.addAttribute("student", student);
	return "create_student";
	
}

@PostMapping("/students")
public String saveStudent(@ModelAttribute("student") Student student) {
	studentService.saveStudent(student);
	return "redirect:/students";
}

@GetMapping("/students/edit/{id}")
public String editStudentForm(@PathVariable Long id, Model model) {
	model.addAttribute("student", studentService.getStudentById(id));
	return "edit_student";
}

@PostMapping("/students/{id}")
public String updateStudent(@PathVariable Long id,
		@ModelAttribute("student") Student student,
		Model model) {
	
	// get student from database by id
	Student existingStudent;
	try {
		existingStudent = StudentServiceImpl.deleteStudentById(id);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	existingStudent.setId(id);
	existingStudent.setFirstname(student.getFirstname());
	existingStudent.setFirstname(student.getFirstname());
	existingStudent.setEmail(student.getEmail());
	
	StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
	// save updated student object
	studentServiceImpl.updateStudent(existingStudent);
	return "redirect:/students";		
}

// handler method to handle delete student request

@GetMapping("/students/{id}")
public String deleteStudent(@PathVariable Long id) {
	StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
	studentServiceImpl.deleteStudentById(id);
	return "redirect:/students";
}

}