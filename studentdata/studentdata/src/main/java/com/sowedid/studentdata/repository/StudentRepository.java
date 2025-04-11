package com.sowedid.studentdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sowedid.studentdata.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
