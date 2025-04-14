package com.codesnippet.springdemoapplication.repository;

import com.codesnippet.springdemoapplication.entity.Applicant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface ApplicantPagingAndSortingRepository extends ListPagingAndSortingRepository<Applicant,Long> , CrudRepository<Applicant,Long> {
}
