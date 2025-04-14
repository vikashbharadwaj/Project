package com.udemy.Udemyjpa.service;

import com.udemy.Udemyjpa.entiy.Student;
import com.udemy.Udemyjpa.repository.AddressRepository;
import com.udemy.Udemyjpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    AddressRepository addressRepository;

    public List<Student> getAllStudent(){
       return studentRepository.findAll();
    }

    public void createStudent(Student student){


    }

    public Student updateStudent(long id, Student student) {
       Optional<Student> student1= studentRepository.findById( id);
        student1.ifPresent(s -> s.setFirstName(student.getFirstName()));
        student1.ifPresent(s -> s.setLastName(student.getLastName()));
       return studentRepository.save(student);

    }

    public String deleteStudent(long id) {
        studentRepository.deleteById(id);
        return null;
    }

    public Student getByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    public Student getByFirstNameAndLastName(String firstName, String lastName) {
      //  return studentRepository.findByFirstNameAndLastName(firstName,lastName);
        return (Student) studentRepository.getByFirstNameAndLastName(firstName, lastName);
    }

    public List<Student> getByFirstNameOrLastName(String firstName, String lastName) {
        return studentRepository.findByFirstNameOrLastName(firstName,lastName);
    }

    public List<Student> getAllStudentWithPagination(int pageN0, int pageSize) {
        Pageable pageable= PageRequest.of(pageN0-1,pageSize);
        return studentRepository.findAll(pageable).getContent();

    }

    public List<Student> getAllStudentWithSorting() {
        Sort sort=Sort.by(Sort.Direction.ASC,"firstName");
        return studentRepository.findAll(sort);
    }

    public List<Student> like(String firstName) {
        return studentRepository.findByFirstNameContains(firstName);
    }

    public List<Student> startWith(String firstName) {
        return studentRepository.findByFirstNameStartsWith(firstName);
    }

    public Integer updateFirstNameJpql(long id, String firstName) {
        return studentRepository.updateFirstName(id,firstName);
    }

    public Integer delteStudentMap(String firstName) {
      return studentRepository.deleteByfirstName(firstName);
    }
}
