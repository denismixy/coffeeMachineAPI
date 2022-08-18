package ru.mikhailin.coffeemachineapi.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UpdateCoffeeRequestDTO {
    @NonNull
    private final Integer orderId;
    @NonNull
    private final LocalDateTime datetime;
    @NonNull
    private final Integer customerId;
}
