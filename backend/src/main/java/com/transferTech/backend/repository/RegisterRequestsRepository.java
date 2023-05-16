package com.transferTech.backend.repository;

import com.transferTech.backend.entity.RegisterRequests;

public interface RegisterRequestsRepository {

    RegisterRequests create(RegisterRequests request);
    RegisterRequests findById(Long id);
    RegisterRequests update(RegisterRequests request);
    void delete(RegisterRequests request);
}
