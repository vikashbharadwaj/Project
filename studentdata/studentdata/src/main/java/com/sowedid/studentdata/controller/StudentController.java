package com.sowedid.studentdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sowedid.responsedto.StudentResponseDTO;
import com.sowedid.studentdata.requestdto.StudentRequestDTO;
import com.sowedid.studentdata.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	@PostMapping("/save")
	public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody StudentRequestDTO requestDTO){
		return studentService.createStudent(requestDTO);
		
	}

	@GetMapping("/all")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
        return studentService.getAllStudents();
    }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
		return studentService.deleteStudent(id);
		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateStudent(@PathVariable Long id,@RequestBody StudentRequestDTO requestDTO){
		return studentService.updateStudent(id,requestDTO);
		
	}
	
}
