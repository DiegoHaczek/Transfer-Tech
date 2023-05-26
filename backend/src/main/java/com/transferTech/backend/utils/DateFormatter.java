package com.transferTech.backend.utils;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class DateFormatter {
    public String formatDate(Object dateTimeRow) {
        return String.format("%1$TF %1$TT",(Timestamp) dateTimeRow);
    }

}
