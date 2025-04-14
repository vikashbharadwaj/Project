package com.codesnippet.springdemoapplication.repository;

import com.codesnippet.springdemoapplication.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface ApplicantCrudRepository extends JpaRepository<Applicant,Long> {

   Book findBookByNameAndPhoneOrUserId(String name,String phone,Long id);
    Book findBookByNameIn(List<String> name);

}
