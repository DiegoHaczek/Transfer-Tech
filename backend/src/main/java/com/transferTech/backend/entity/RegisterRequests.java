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

    private Long userId;

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

    @Column(name = "REQUEST_STATUS")
    private String requestStatus;


}
