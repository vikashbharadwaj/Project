package com.codesnippet.springdemoapplication.service;

import com.codesnippet.springdemoapplication.entity.Applicant;
import com.codesnippet.springdemoapplication.repository.ApplicantCrudRepository;
import com.codesnippet.springdemoapplication.repository.ApplicantJpaRepository;
import com.codesnippet.springdemoapplication.repository.ApplicantPagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {
   @Autowired
   private ApplicantCrudRepository applicantCrudRepository;
   @Autowired
   private ApplicantJpaRepository applicantJpaRepository;
   @Autowired
   private ApplicantPagingAndSortingRepository applicantPagingAndSortingRepository;


    public List<Applicant> getAllApplicants() {
        return applicantCrudRepository.findAll();
    }
    public List<Applicant> getApplicantByStatus(String status) {
        return applicantJpaRepository.findByStatusOrderByNameAsc(status);
    }
    @Cacheable("name")
    public List<Applicant> getApplicantByPartialName(String name) {
        return applicantJpaRepository.findApplicantsByPartialName(name);
    }
    public Applicant saveApplicantCrud(Applicant applicant) {
        return applicantCrudRepository.save(applicant);
    }

    public Iterable<Applicant> getApplicantsWithPagination(int page, int size) {
        return applicantPagingAndSortingRepository.findAll(PageRequest.of(page,size));
    }

}