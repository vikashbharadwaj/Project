package com.bitsnbytes.productlist.contoller;

import com.bitsnbytes.productlist.dto.UserDto;
import com.bitsnbytes.productlist.entity.User;
import com.bitsnbytes.productlist.security.JwtUtil;
import com.bitsnbytes.productlist.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MyUserDetailService myUserDetailService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public User register(@RequestBody User user){
       return myUserDetailService.createUser(user);

    }
    @PostMapping("/login")
    public String login(@RequestBody UserDto user){
      Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);


        List<String>roles=authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

        UserDetails userDetails = myUserDetailService.loadUserByUsername(user.getUsername());
       return jwtUtil.generateToken(userDetails.getUsername(), roles);


    }
}
