package com.example.vikas.sms.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vikas.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
