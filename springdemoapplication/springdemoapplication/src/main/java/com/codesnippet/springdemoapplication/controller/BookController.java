package com.codesnippet.springdemoapplication.controller;

import com.codesnippet.springdemoapplication.entity.Book;
import com.codesnippet.springdemoapplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        Book save = bookService.addBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("search")
    public ResponseEntity<Book> getBook(@RequestParam Integer id) {
        Book name = bookService.getBook(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);


    }

    @PutMapping("/updateBook")
    public ResponseEntity<?> updateBook(@RequestBody Book book) {
        Book updateBook = bookService.updateBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/healthy")
   public String getHealth(){
        return "healthy";
   }
}