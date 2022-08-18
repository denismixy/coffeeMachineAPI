package ru.mikhailin.coffeemachineapi.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CreateCoffeeRequestDTO {
    @NonNull
    private final Integer customerId;
    @NonNull
    private final LocalDateTime datetime;
}
