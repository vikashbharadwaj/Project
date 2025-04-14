package com.codesnippet.springdemoapplication.repository;

import com.codesnippet.springdemoapplication.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    public Book findBookById(Integer id);
}
