package com.bitsnbytes.productlist.service;

import com.bitsnbytes.productlist.entity.User;
import com.bitsnbytes.productlist.repository.UserRepository;
import com.bitsnbytes.productlist.security.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;


    public User createUser(User user) {
        user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
     return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        if(user.isEmpty()) throw new UsernameNotFoundException("user not found");
        return new UserPrinciple(user.get());

    }
}
