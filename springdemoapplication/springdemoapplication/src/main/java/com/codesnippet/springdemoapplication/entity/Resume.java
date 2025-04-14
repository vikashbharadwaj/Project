package com.codesnippet.springdemoapplication.entity;

import jakarta.persistence.*;

@Entity
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;
    @OneToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;
}
