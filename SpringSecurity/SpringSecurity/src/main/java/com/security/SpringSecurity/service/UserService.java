package com.security.SpringSecurity.service;

import com.security.SpringSecurity.model.Userss;
import com.security.SpringSecurity.repository.UseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UseRepository useRepository;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);



    public Userss register(Userss userss){
        userss.setPassword(encoder.encode(userss.getPassword()));
        return  useRepository.save(userss);


    }
}
