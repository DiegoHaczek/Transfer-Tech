package com.transferTech.backend.entity;

import jakarta.persistence.Table;
import lombok.Data;

@Data

@Table(name = "register_requests")
public class RegisterRequests {

    private Long id;
    private Long userId;
    private String selfiePhoto;
    private String identityCardFront;
    private String identityCardBack;
    private String currentJobSituation;
    private String civilStatus;
    private String requestStatus;


}
