package net.java.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.java.springboot.dto.Userdto;
import net.java.springboot.entity.Userentity;
import net.java.springboot.repository.Usercustomimp;
import net.java.springboot.service.Userservice;

@RestController
public class Usercontroller {
	@Autowired
	Userservice userservice;
	
	//@Autowired
	//Usercustomimp usercustomimp;

	 @PostMapping(path="create")    
	 public Userdto createUser(@RequestBody Userdto userdto) {
		return userservice.saveUser(userdto);
		
	}
	 @GetMapping
	 public List<Userdto>getAlluser(){
		 return userservice.getAlluser();
		 
	 }
	
	 @GetMapping("view")
	 public Userdto readkro(@RequestParam (name= "q")int id) {
		return userservice.readkro(id);
	}
	 @PutMapping("update")
	 public Optional<Userdto> updatekro(@RequestBody Userdto userdto,@RequestParam (name="q")int id) {
		return  userservice.updatekro(userdto,id);
		 
	 }
	 @DeleteMapping("delete/{id}")
	 public void deletekro(@PathVariable("id")int id) {
		 userservice.deletekro(id);
		 
	 
		 
	 }
	 @GetMapping("byname/{name}")
	 public List<Userentity>getbyfirstName(@PathVariable("name") String firstName){
		return userservice.getbyfirstName(firstName);
		 
	 }
	   
	    @GetMapping("/search")
	    public ResponseEntity<List<Userdto>> getUsers(@RequestParam String searchText,@RequestParam(required=false)String city) { 
	        List<Userdto> users = userservice.getUsers(searchText,city); // Call the service method
	        return new ResponseEntity<>(users, HttpStatus.OK); 
	    
	    }
	    @GetMapping("firstlast/{firstName}/{lastName}")
	    public List<Userentity>getByFirstNameandlastname(@PathVariable String firstName,@PathVariable String lastName){
			return userservice.getByFirstNameandlastname(firstName,lastName);
	    	
	    }
	    @GetMapping("first/{firstName}/{lastName}")
	    public List<Userentity>Findbyfirstnameandlastname(@PathVariable String firstName,@PathVariable String lastName){
			return userservice.Findbyfirstnameandlastname(firstName,lastName);
	    	
	    }
	    @PutMapping("updatefirst/{id}/{firstName}")
	    public Integer updatejpql(@PathVariable int id,@PathVariable String firstName) {
			return userservice.updatejpql(id,firstName);
	    	
	    }
	    @DeleteMapping("deletestudent/{firstName}")
	    public void deletejpql(@PathVariable String firstName) {
	    	userservice.deletejpql(firstName);
	    	
	    	
	    }
}
