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
                .movementId((Long) resultRow.get("id"))
                .transferCode((Long) resultRow.get("transfer_code"))
                .userName(getNameByMovementType(resultRow))
                .accountId((Long) resultRow.get("account_id"))
                .type((String) resultRow.get("type"))
                .amount((Double) resultRow.get("amount"))
                .description(getDescription(resultRow))
                .dateTime(formatDate(resultRow.get("date_time")))
                .build();
    }
    private String formatDate(Object dateTimeRow) {
        return String.format("%1$TF %1$TT",(Timestamp) dateTimeRow);
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
