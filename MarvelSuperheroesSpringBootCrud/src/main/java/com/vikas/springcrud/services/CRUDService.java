package com.vikas.springcrud.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.springcrud.models.Characters;
import com.vikas.springcrud.repositories.SuperheroCharacterRepositry;

@Service
public class CRUDService {

    @Autowired
    SuperheroCharacterRepositry superheroCharacterRepositry;

    // Create a new superhero
    public void createHero(Characters superhero) {
        superheroCharacterRepositry.save(superhero);
    }

    // Read superhero details by ID
    public Characters readSuperhero(int id) {
        return superheroCharacterRepositry.findById(id).get();
                
    }

    // Update superhero name
    public void updateName(Characters superhero, int id) {
        Characters superheroUpdated = readSuperhero(id);
        superheroUpdated.setName(superhero.getName());
        superheroCharacterRepositry.save(superheroUpdated);
    }

    // Delete superhero by ID
    public void deleteHero(int id) {
        superheroCharacterRepositry.deleteById(id);
    }
}