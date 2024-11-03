package com.gaurish.BankIt.Repository;

import com.gaurish.BankIt.Entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Function;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmailOrPhoneNumber(String email, String phoneNumber);
    boolean existsByAccountNumber(String accountNumber);

    User findByAccountNumber(String accountNumber);
}
