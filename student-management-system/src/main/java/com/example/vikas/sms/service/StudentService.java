package com.example.vikas.sms.service;

import java.util.List;

import com.example.vikas.sms.entity.Student;

public interface StudentService {
      List<Student>getAllStudent();

	

	Student saveStudent(Student student);
	Student getStudentById(Long id);
	Student updateStudent(Student student);
	
	Student deleteStudentById(Long id);
}
