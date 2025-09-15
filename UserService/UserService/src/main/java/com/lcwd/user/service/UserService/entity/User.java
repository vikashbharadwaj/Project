package com.lcwd.user.service.UserService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "micro_user")
public class User {
    @Id
    private String userId;
    private String email;
    private String name;
    private String about;
    @Transient
    private List<Rating> rating=new ArrayList<>();
}
