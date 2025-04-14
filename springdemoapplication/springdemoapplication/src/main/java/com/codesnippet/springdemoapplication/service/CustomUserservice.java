package com.codesnippet.springdemoapplication.service;

import com.codesnippet.springdemoapplication.repository.SecuriRepository;
//import com.codesnippet.springdemoapplication.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserservice implements UserDetailsService {
    @Autowired
    SecuriRepository securiRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return securiRepository.findByUserName(username)
                .orElseThrow(()-> new UsernameNotFoundException("username not found"));
    }
}
