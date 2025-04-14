package com.codesnippet.springdemoapplication.controller;

import com.codesnippet.springdemoapplication.entity.Applicant;
import com.codesnippet.springdemoapplication.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppliantController {

    @Autowired
    private ApplicantService applicantService;

    @GetMapping
    public List<Applicant> getAllApplicants() {
        return applicantService.getAllApplicants();
    }
    @PostMapping("/konda")
    public Applicant saveApplicant(@RequestBody Applicant applicant) {
        System.out.println("Reached controller");
        return applicantService.saveApplicantCrud(applicant);
    }

    @GetMapping("/page")
    public Iterable<Applicant> getApplicantsWithPagination(
            @RequestParam int page,
            @RequestParam int size) {
        return applicantService.getApplicantsWithPagination(page, size);
    }
    @GetMapping("/getByStatus")
    public List<Applicant> getApplicantByStatus(@RequestParam String status) {
        return applicantService.getApplicantByStatus(status);
    }
    @GetMapping("/getByName")
    public String getApplicantByPartialName(@RequestParam String name) {
        applicantService.getApplicantByPartialName(name);
        return "name";
    }
    @GetMapping("/healthy")
    public String getHealth(){
        return "healthy";
    }
}