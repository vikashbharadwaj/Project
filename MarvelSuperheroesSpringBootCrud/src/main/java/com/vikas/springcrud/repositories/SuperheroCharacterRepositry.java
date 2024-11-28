package com.vikas.springcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vikas.springcrud.models.Characters;
@Repository
public interface SuperheroCharacterRepositry extends JpaRepository<Characters, Integer> {

}
