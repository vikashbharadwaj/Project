package net.java.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.java.springboot.dto.Adressdto;
import net.java.springboot.dto.Userdto;
import net.java.springboot.service.Adressservice;
import net.java.springboot.service.Userservice;
@RestController
public class Adresscontroller {
	
	@Autowired
	Adressservice adressservice;
	
	//@Autowired
	//Usercustomimp usercustomimp;

	 @PostMapping(path="post")    
	 public Adressdto createUser(@RequestBody Adressdto adressdto) {
		return adressservice.save(adressdto);
		
	}
	 @GetMapping("all")
	 public List<Adressdto>getAllusers(){
		 return adressservice.getAllusers();
		 
	 }
	
	 @GetMapping("get")
	 public Adressdto read(@RequestParam (name= "v")int id) {
		return adressservice.read(id);
	}
	 @PutMapping("put")
	 public Optional<Adressdto> update(@RequestBody Adressdto adressdto,@RequestParam (name="v")int id) {
		return  adressservice.update(adressdto,id);
		 
	 }
	 @DeleteMapping("del/{d}")
	 public void delete(@PathVariable("d")int id) {
		 adressservice.delete(id);
		 
	 
		 
	 }

}
