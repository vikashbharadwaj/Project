package com.bitsnbytes.productlist.repository;

import com.bitsnbytes.productlist.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CateogryRepository extends JpaRepository<Category,Long> {

    Optional<Category>findByName(String cateogryName);

}
