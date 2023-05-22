package com.transferTech.backend.mapper;

import com.transferTech.backend.dto.movement.MovementDto;
import com.transferTech.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Map;

@Component
@AllArgsConstructor
public class MovementDtoMapper {

    private final UserRepository userRepository;

    public MovementDto QueryResultRowToDto(Map<String,Object> resultRow) {
        return MovementDto.builder()
                .id((Long) resultRow.get("id"))
                .userName(getNameByMovementType(resultRow))
                .type((String) resultRow.get("type"))
                .amount((Double) resultRow.get("amount"))
                .description(getDescription(resultRow))
                .dateTime(String.format("%1$TF %1$TT",(Timestamp) resultRow.get("date_time")))
                .build();

    }
    private String getDescription(Map<String,Object> resultRow) {
        return (resultRow.get("description") == null)? "" :
                (String) resultRow.get("description");
    }
    private String getNameByMovementType(Map<String,Object> resultRow) {
        return switch ((String) resultRow.get("type")){
            case "Transferencia Enviada" -> userRepository.findUserNameById
                    ((Long)resultRow.get("receiver_account_id")).getName();
            case "Transferencia Recibida" -> userRepository.findUserNameById
                    ((Long)resultRow.get("sender_account_id")).getName();
            default -> "";
        };
    }
}
