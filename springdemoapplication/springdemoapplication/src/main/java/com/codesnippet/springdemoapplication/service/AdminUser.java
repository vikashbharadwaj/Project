package com.codesnippet.springdemoapplication.service;

import com.codesnippet.springdemoapplication.entity.Securit;
import com.codesnippet.springdemoapplication.repository.SecuriRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminUser {


    @Bean
    public CommandLineRunner createAdminUser(SecuriRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                Securit admin = new Securit();
                admin.setUserName("admin");
                admin.setPassword(passwordEncoder.encode("admin1234")); // Securely store password
                admin.setRole("ROLE_ADMIN");

                userRepository.save(admin);
                System.out.println("Default admin user created!");
            }
        };
    }
}

