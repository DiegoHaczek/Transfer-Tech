package com.transferTech.backend.repository;

import com.transferTech.backend.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findByAccountNumber(BigInteger accountNumber);
    Optional<Account> findByAlias(String alias);
    boolean existsByAccountNumber(BigInteger accountNumber);
    boolean existsByAlias(String alias);

    boolean existsByUserId(Long userId);

}
