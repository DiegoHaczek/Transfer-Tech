package com.transferTech.backend.repository;

import com.transferTech.backend.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer,Long> {

}
