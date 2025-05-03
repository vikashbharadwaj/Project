package com.bitsnbytes.productlist.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "User_security")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
}
