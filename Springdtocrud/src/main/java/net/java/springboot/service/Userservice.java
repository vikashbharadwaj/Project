package net.java.springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import net.java.springboot.dto.Userdto;
import net.java.springboot.entity.Userentity;
import net.java.springboot.repository.Usercustomimp;
import net.java.springboot.repository.Userrepository;

@Service
public class Userservice {
	@Autowired
	Userrepository userrepository;
	
	@Autowired
	Usercustomimp usercustomimp;
	
	@Autowired
	ModelMapper mapper;
	
	public  Userdto saveUser(Userdto userdto) {
	  Userentity user=mapper.map(userdto, Userentity.class);
	   return mapper.map(userrepository.save(user), Userdto.class);
	  
	}
	public List<Userdto> getAlluser(){
		List<Userentity> userlist=userrepository.findAll();
		return userlist.stream().map(use ->mapper.map(use, Userdto.class)).collect(Collectors.toList());
		
	}
	public Userdto readkro(int id) {
		Optional<Userentity> user=userrepository.findById(id);
		return mapper.map(user, Userdto.class);
	}
	public Optional<Userdto> updatekro(Userdto userdto, int id) {
	    Optional<Userentity> userOptional = userrepository.findById(id);
	    
	    return userOptional.map(existUser -> {
	    
	        mapper.map(userdto, existUser);
	        
	        
	        return mapper.map(userrepository.save(existUser), Userdto.class);
	    });
	}
	public void deletekro(int id) {
	  userrepository.deleteById(id);
	
	}
	public List<Userentity> getbyfirstName( String firstName){
		return userrepository.findByFirstName(firstName);
		
	
}
	 public List<Userdto> getUsers(String searchText,String city) {
	        return usercustomimp.findUsersByText(searchText,city);
	 }
	public List<Userentity> getByFirstNameandlastname(String firstName, String lastName) {

		return userrepository.findByFirstNameAndLastName(firstName, lastName);
	}
	public List<Userentity> Findbyfirstnameandlastname(String firstName, String lastName) {

		//return userrepository.findByFirstNameOrLastName(firstName, lastName);
		return userrepository.getByFirstNameAndLastName(firstName, lastName);
	}
	public Integer updatejpql(int id, String firstName) {
		return userrepository.updateFirstName(id, firstName);
	}
	public void deletejpql(String firstName) {
		userrepository.deletebyFirstname(firstName);
		
	}
	 
	 
	 }	 