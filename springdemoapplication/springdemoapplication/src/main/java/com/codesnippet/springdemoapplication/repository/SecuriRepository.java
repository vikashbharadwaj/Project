package com.codesnippet.springdemoapplication.repository;

import com.codesnippet.springdemoapplication.entity.Securit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface SecuriRepository extends JpaRepository<Securit,Long> {
    Optional<Securit>findByUserName(String username);

    Collection<Object> findByUsername(String admin);
}
