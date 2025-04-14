package com.codesnippet.springdemoapplication.service;

import com.codesnippet.springdemoapplication.entity.Book;
import com.codesnippet.springdemoapplication.repository.BookRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @Mock
    BookRepository bookRepository;
    @InjectMocks
    BookService bookService;
     @BeforeAll
    public static void init(){
         System.out.println("before all");

    }
    @BeforeEach
    public  void initeach(){
        System.out.println("before all");

    }


    @Test
    void bookTest(){
        Book book=new Book();
        book.setId(1);
        book.setAuthor("vikas");
        book.setGenere("harry");
        book.setTitle("java");
        when(bookRepository.save(book)).thenReturn(book);
       Book book1= bookService.addBook(book);

       assertNotNull(book1);

        assertEquals(book.getId(),book1.getId());
        assertEquals(book.getAuthor(),book1.getAuthor());
        assertTrue(book.getId());


    }

    private void assertTrue(Integer id) {
    }
    @Test
    public void updateBook(){
         bookService.updateBook(new Book());
         verify(bookRepository,times(1));

    }
    @AfterAll
    public static void Destroy(){
         System.out.println("after all");


    }
    @AfterEach
    public void cleanup(){
         System.out.println("aftereach");
    }

}