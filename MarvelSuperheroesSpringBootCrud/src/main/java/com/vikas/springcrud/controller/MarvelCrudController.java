package com.vikas.springcrud.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import com.vikas.springcrud.models.Characters;
import com.vikas.springcrud.services.CRUDService;

@RestController
public class MarvelCrudController {

    @Autowired
    CRUDService crudService;

    // Create a new superhero
    @PostMapping(path="create")
    public void createSuperhero(@RequestBody Characters superhero) {
        crudService.createHero(superhero);
    }

    // Read superhero details by ID
    @GetMapping("read")
    public Characters readSuperhero(@RequestParam(name = "id") int id) {
        return crudService.readSuperhero(id);
    }

    // Update superhero name
    @PutMapping("update")
    public void updateName(@RequestBody Characters superhero, @RequestParam(name = "id") int id) {
        crudService.updateName(superhero, id);
    }

    // Delete superhero by ID
    @DeleteMapping("delete")
    public void deleteHero(@RequestParam(name = "id") int id) {
        crudService.deleteHero(id);
    }}