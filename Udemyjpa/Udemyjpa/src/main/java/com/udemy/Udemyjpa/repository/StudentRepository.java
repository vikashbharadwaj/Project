package com.udemy.Udemyjpa.repository;

import com.udemy.Udemyjpa.entiy.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Student findByFirstName(String firstName);
    Student findByFirstNameAndLastName(String firstName,String lastName);
    List<Student> findByFirstNameOrLastName(String firstName, String lastName);
    List<Student> findByFirstNameIn(List<String> firstNames);
    List<Student> findByFirstNameContains(String firstName);
    List<Student> findByFirstNameStartsWith(String firstName);
    @Query("from  Student where firstName=:firstName and lastName=:lastName")
   List<Student>getByFirstNameAndLastName(String firstName,String lastName);
    @Modifying
    @Transactional
    @Query("update Student set firstName=:firstName where id=:id")
    Integer updateFirstName(long id,String firstName);
    @Modifying
    @Transactional
    @Query("delete from Student where firstName=:firstName")
    Integer deleteByfirstName(String firstName);
}
