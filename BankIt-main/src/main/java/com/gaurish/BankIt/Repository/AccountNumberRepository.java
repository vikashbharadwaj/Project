package com.gaurish.BankIt.Repository;

import com.gaurish.BankIt.Entity.AccountNumberCounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountNumberRepository extends JpaRepository<AccountNumberCounter, Long> {

}
