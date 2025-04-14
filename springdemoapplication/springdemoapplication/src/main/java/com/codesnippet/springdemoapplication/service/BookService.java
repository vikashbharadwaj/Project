package com.codesnippet.springdemoapplication.service;

import com.codesnippet.springdemoapplication.entity.Book;
import com.codesnippet.springdemoapplication.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

@Service
public class BookService {
   @Autowired
   BookRepository bookRepository;

    @Transactional
    public Book addBook(Book book) {
      return bookRepository.save(book);
    }
    public Book getBook(Integer id) {
       return bookRepository.findBookById(id);

    }

    public Book updateBook(Book book) {
      return   bookRepository.save(book);
    }
}
