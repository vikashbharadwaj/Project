package net.java.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.java.springboot.entity.Address;
import net.java.springboot.entity.Userentity;
@Repository
public interface Adressrepository extends JpaRepository<Address,Integer>{

	
	Object save(Optional<Address> users);
}
