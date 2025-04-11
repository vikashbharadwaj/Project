package com.sowedid.studentdata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sowedid.responsedto.StudentResponseDTO;
import com.sowedid.studentdata.model.Student;
import com.sowedid.studentdata.repository.StudentRepository;
import com.sowedid.studentdata.requestdto.StudentRequestDTO;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public ResponseEntity<StudentResponseDTO> createStudent(StudentRequestDTO requestDTO) {
		Student student=new Student();
		student.setName(requestDTO.getName());
		student.setCourse(requestDTO.getCourse());
		student.setRollno(requestDTO.getRollno());
		student.setAge(requestDTO.getAge());
		
	Student	savedstudent=studentRepository.save(student);
	StudentResponseDTO responseDTO=new StudentResponseDTO();
	responseDTO.setId(savedstudent.getId());
	responseDTO.setAge(savedstudent.getAge());
	responseDTO.setName(savedstudent.getName());
	responseDTO.setRollno(savedstudent.getRollno());
	responseDTO.setCourse(savedstudent.getCourse());
		return new ResponseEntity<>(responseDTO,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<List<StudentResponseDTO>> getAllStudents(){
		
		        List<Student>  allRecords=studentRepository.findAll();  
		     
		        List<StudentResponseDTO> responseDTOList = allRecords.stream().map(student -> {
		            StudentResponseDTO responseDTO = new StudentResponseDTO();
		            responseDTO.setId(student.getId());
		            responseDTO.setName(student.getName());
		            responseDTO.setAge(student.getAge());
		            responseDTO.setCourse(student.getCourse());
		            responseDTO.setRollno(student.getRollno());
		            return responseDTO; 
		        }).toList();

		       
		return new ResponseEntity<List<StudentResponseDTO>>(responseDTOList,HttpStatus.OK);
		
	}

	public ResponseEntity<Void> deleteStudent(Long id) {
		// TODO Auto-generated method stub
		
		             Optional<Student> isavaible=studentRepository.findById(id);
		             if(isavaible.isPresent()) {
		            	 studentRepository.deleteById(id);
		            	 return new ResponseEntity<>(HttpStatus.CONFLICT);
		             }
		             
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<String> updateStudent(Long id, StudentRequestDTO requestDTO) {
		 Optional<Student> isavaible=studentRepository.findById(id);
         if(isavaible.isPresent()) {
        	                Student student=isavaible.get();
        	                student.setName(requestDTO.getName());
        	        		student.setCourse(requestDTO.getCourse());
        	        		student.setRollno(requestDTO.getRollno());
        	        		student.setAge(requestDTO.getAge());
        	        		Student	savedstudent=studentRepository.save(student);
        	        return		new ResponseEntity<String>("student updated",HttpStatus.OK);
         }
		return new ResponseEntity<String>("not found",HttpStatus.NOT_FOUND);
	}

}
