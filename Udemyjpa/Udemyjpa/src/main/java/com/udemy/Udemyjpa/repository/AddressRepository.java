package com.udemy.Udemyjpa.repository;

import com.udemy.Udemyjpa.entiy.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
