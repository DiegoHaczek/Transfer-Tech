package com.transferTech.backend.repository;

import com.transferTech.backend.entity.Account;

public interface AccountRepository {
    Account create(Account account);
    Account findById(int id);
    Account update(Account account);
    void delete(Account account);
}
