package com.transferTech.backend.repository;

import com.transferTech.backend.entity.Deposit;

public interface DepositRepository {
    Deposit create(Deposit deposit);
    Deposit findById(int id);
    Deposit update(Deposit deposit);
    void delete(Deposit deposit);
}
