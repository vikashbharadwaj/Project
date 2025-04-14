package com.udemy.Udemyjpa.repository;

import com.udemy.Udemyjpa.entiy.Student;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Student findByFirstName(String firstName);
    Student findByFirstNameAndLastName(String firstName,String lastName);
    List<Student> findByFirstNameOrLastName(String firstName, String lastName);
    List<Student> findByFirstNameIn(List<String> firstNames);
    List<Student> findByFirstNameContains(String firstName);
    List<Student> findByFirstNameStartsWith(String firstName);
    @Query("from  Student where firstName=:firstName and lastName=:lastName")
   List<Student>getByFirstNameAndLastName(String firstName,String lastName);
    @Modifying
    @Transactional
    @Query("update Student set firstName=:firstName where id=:id")
    Integer updateFirstName(long id,String firstName);
    @Modifying
    @Transactional
    @Query("delete from Student where firstName=:firstName")
    Integer deleteByfirstName(String firstName);


//    Book findBookByNameAndPhoneOrUserId(String name, String phone, Long id);
//    Book findBookByNameIn(List<String> name);
   // jab jayda record chahiye
//  Page  <Book >findBookByNameStartingWith(String name, Pageable page);
//<Book >findBookByNameStartingWith(String name, Sort sort);
    //yaha userdetail mapped hai userAdress se isliye join use kiye hai or ad ki jagah on ka koi zarrorat nahi hai
//    @Query("SELECT ud from UserDetails ud JOIN ud.UserAdress ad where ud.name=userName")
//    List<Book >findBookByNameIn(@Param("üserName") String userName);
     //jab hamko ek userdetail se or ek useradress se koi filed return karwana ho
    //join featch krke n1 problem solve kar sakte hai
    @Query("SELECT ud.name,ad.country from UserDetails ud JOIN ud.UserAdress ad where ud.name=userName")
    List<Object[]>findBookByNameIn(@Param("üserName") String userName);
    //child table
   // we solve    n1 problem
  //  @EntityGraph(attributePaths = "userAdressList")

}
