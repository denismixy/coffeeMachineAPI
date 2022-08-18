package ru.mikhailin.coffeemachineapi.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class GetCoffeeResponseDTO {
    private Integer orderId;
    private LocalDateTime datetime;
    private Integer customerId;
}
