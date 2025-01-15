package net.java.springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.java.springboot.dto.Adressdto;
import net.java.springboot.dto.Userdto;
import net.java.springboot.entity.Address;
import net.java.springboot.entity.Userentity;
import net.java.springboot.repository.Adressrepository;
import net.java.springboot.repository.Usercustomimp;
import net.java.springboot.repository.Userrepository;
@Service
public class Adressservice {
	
	@Autowired
	Adressrepository adressrepository;
	
	@Autowired
	Usercustomimp usercustomimp;
	
	@Autowired
	ModelMapper mapper;
	
	public  Adressdto save(Adressdto adressdto) {
	  Address users=mapper.map(adressdto, Address.class);
	   return mapper.map(adressrepository.save(users), Adressdto.class);
	  
	}
	public List<Adressdto> getAllusers(){
		List<Address> userlists=adressrepository.findAll();
		return userlists.stream().map(use ->mapper.map(use, Adressdto.class)).collect(Collectors.toList());
		
	}
	public Adressdto read(int id) {
		Optional<Address> users=adressrepository.findById(id);
		return mapper.map(users, Adressdto.class);
	}
	public Optional<Adressdto> update(Adressdto adressdto, int id) {
	    Optional<Address> userOptionals = adressrepository.findById(id);
	    
	    return userOptionals.map(existUsers -> {
	    
	        mapper.map(adressdto, existUsers);
	        
	        
	        return mapper.map(adressrepository.save(existUsers), Adressdto.class);
	    });
	}
	public void delete(int id) {
		adressrepository.deleteById(id);
	
	}

}
