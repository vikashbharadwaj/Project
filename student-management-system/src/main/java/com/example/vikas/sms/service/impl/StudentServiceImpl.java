package com.example.vikas.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.vikas.sms.entity.Student;
import com.example.vikas.sms.repositry.StudentRepository;
import com.example.vikas.sms.service.StudentService;
@Service
public abstract class StudentServiceImpl implements StudentService {
	
	private static final Object student = null;
	private static  StudentRepository studentRepository;
        public List<Student>getAllStudent(){
		return null;
	}
		public Student deleteStudentById(Long id) {
			studentRepository.deleteById(id);
			return null;
			
			
		}
		public Student updateStudent(Student existingStudent) {
			return studentRepository.save(student);
			
			
		}
		@Override
		public Student getStudentById(Long id) {
	
			return studentRepository.findById(id).get();
			
			
		}
		public Student saveStudent(Student student) {
			return studentRepository.save(student);
			
		}
	
}
