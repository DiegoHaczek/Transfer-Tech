package com.transferTech.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendVerificationEmail(String userEmail, Long verificationCode){
        try {
            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(userEmail);
            email.setSubject("Verificación de Email de Transfer Tech");
            email.setText("Estimado/a: \n Su código de verificación es: " + verificationCode +
                    ".\n No comparte este código con nadie. \n Transfer Tech 2023 ");
            mailSender.send(email);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
