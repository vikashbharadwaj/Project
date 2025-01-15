package net.java.springboot.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import net.java.springboot.dto.Userdto;
import net.java.springboot.entity.Userentity;

@Service
public class Usercustomimp {
	
	@Autowired
	EntityManager em;

    public List<Userdto> findUsersByText(String searchText,String city) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Userdto> cq = cb.createQuery(Userdto.class);
        Root<Userentity> user = cq.from(Userentity.class);

        Predicate firstNamePredicate = cb.equal(user.get("firstName"), searchText);
        Predicate emailPredicate = cb.like(user.get("email"), "%" + searchText + "%");
        Predicate lastNamePredicate= cb.equal(user.get("lastName"), searchText);
        Predicate searchpredicate=  cb.or(cb.or(firstNamePredicate, emailPredicate,lastNamePredicate));
       if(city !=null && !city.isEmpty() ) {
        Predicate cityPredicate = cb.equal(user.get("city"), city);
          searchpredicate = cb.and(searchpredicate ,cityPredicate);
       }
       cq.select(cb.construct(Userdto.class,user.get("lastName"),user.get("id"),user.get("email")));
          cq.where(searchpredicate);

        TypedQuery<Userdto> query = em.createQuery(cq);
        return query.getResultList();
    }
	
	
}


