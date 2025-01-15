package net.java.springboot.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import net.java.springboot.dto.Userdto;
import net.java.springboot.entity.Userentity;
@Repository
public interface Userrepository extends JpaRepository<Userentity,Integer>
{

	Object save(Optional<Userentity> user);
	
	List<Userentity> findByFirstName(String firstName);
	
	List <Userentity> findByFirstNameAndLastName(String firstName,String lastName);
	
	List<Userentity> findByFirstNameOrLastName(String firstName, String lastName);
	@Query("from Userentity where firstName=:firstName and lastName=:lastName")
	List <Userentity> getByFirstNameAndLastName(String firstName,String lastName);
	@Modifying
	@Transactional
	@Query("Update Userentity set firstName=:firstName where id=:id")
	Integer updateFirstName(int id,String firstName);
	@Modifying
	@Transactional
	@Query("delete from Userentity where firstName=:firstName")
	Integer deletebyFirstname(String firstName);

	}

	
	
	
	
	
	  
	

	


