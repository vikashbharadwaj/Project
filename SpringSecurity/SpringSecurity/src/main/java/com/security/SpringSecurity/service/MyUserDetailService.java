package com.security.SpringSecurity.service;

import com.security.SpringSecurity.model.Userpeinciple;
import com.security.SpringSecurity.model.Userss;
import com.security.SpringSecurity.repository.UseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UseRepository useRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {




        Userss userss=useRepository.findByUsername(username);
        if(userss==null){
            System.out.println("user not found");
            throw new UsernameNotFoundException("user not found");
        }
        return new Userpeinciple(userss);
    }
}
