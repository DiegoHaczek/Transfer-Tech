package com.transferTech.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "register_request_status")
public class RegisterRequestStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean approved;
    private boolean rejected;

    // Constructores, getters y setters

    public RegisterRequestStatus() {
    }

    public RegisterRequestStatus(boolean approved, boolean rejected) {
        this.approved = approved;
        this.rejected = rejected;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public boolean isRejected() {
        return rejected;
    }

    public void setRejected(boolean rejected) {
        this.rejected = rejected;
    }
}
