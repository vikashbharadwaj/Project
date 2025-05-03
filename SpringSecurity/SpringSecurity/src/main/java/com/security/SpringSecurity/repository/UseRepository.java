package com.security.SpringSecurity.repository;

import com.security.SpringSecurity.model.Userss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UseRepository extends JpaRepository<Userss,Integer> {

    Userss findByUsername(String username);
}
