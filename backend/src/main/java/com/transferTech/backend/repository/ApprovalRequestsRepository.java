package com.transferTech.backend.repository;

import com.transferTech.backend.entity.ApprovalRequests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovalRequestsRepository extends JpaRepository<ApprovalRequests,Long> {

}
