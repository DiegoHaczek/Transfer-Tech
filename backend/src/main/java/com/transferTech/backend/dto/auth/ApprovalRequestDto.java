package com.transferTech.backend.dto.auth;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class ApprovalRequestDto {

    @NotNull(message = "Selfie photo is required")
    private MultipartFile selfie_photo;

    @NotNull(message = "Identity card front is required")
    private MultipartFile identity_card_front;

    @NotNull(message = "Identity card back is required")
    private MultipartFile identity_card_back;

}
