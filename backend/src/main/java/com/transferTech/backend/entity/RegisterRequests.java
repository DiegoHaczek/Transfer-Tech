package com.transferTech.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "REGISTER_REQUESTS")
public class RegisterRequests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "ID", nullable = false)
    private User user;

    @Column(name = "SELFIE_PHOTO")
    private String selfiePhoto;

    @Column(name = "ID_FRONT_PHOTO")
    private String identityCardFront;

    @Column(name = "ID_BACK_PHOTO")
    private String identityCardBack;

    @Column(name = "CURRENT_JOB_SITUATION")
    private String currentJobSituation;

    @Column(name = "CIVIL_STATUS")
    private String civilStatus;

    @Column(name = "APPROVED")
    private boolean Approved;


}
