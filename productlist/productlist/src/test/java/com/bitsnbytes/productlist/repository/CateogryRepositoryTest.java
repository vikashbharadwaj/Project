package com.bitsnbytes.productlist.repository;

import com.bitsnbytes.productlist.entity.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CateogryRepositoryTest {
    @Autowired
    private CateogryRepository cateogryRepository;


    private Category category;

    @BeforeEach
    void setUp() {
        category=new Category();
        category.setName("test");
        cateogryRepository.save(category);
    }

    @AfterEach
    void tearDown() {
        cateogryRepository.delete(category);
    }

    @Test
    void findByName() {
      Category foundcateogry=  cateogryRepository.findByName("test").orElse(null);
      assertNotNull(foundcateogry);
      assertEquals(category.getName(),foundcateogry.getName());
    }
}