package com.transferTech.backend.repository;

import com.transferTech.backend.entity.Transfer;

public interface TransferRepository {

    Transfer create(Transfer transfer);
    Transfer findById(int id);
    Transfer update(Transfer transfer);
    void delete(Transfer transfer);
}
