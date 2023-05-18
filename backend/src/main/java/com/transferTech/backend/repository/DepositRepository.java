package com.transferTech.backend.repository;

import com.transferTech.backend.entity.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepository extends JpaRepository<Deposit,Long> {
}
