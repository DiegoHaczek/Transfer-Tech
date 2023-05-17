package com.transferTech.backend.repository;

import com.transferTech.backend.entity.ApprovalRequests;

public interface RegisterRequestsRepository {

    ApprovalRequests create(ApprovalRequests request);
    ApprovalRequests findById(Long id);
    ApprovalRequests update(ApprovalRequests request);
    void delete(ApprovalRequests request);
}
