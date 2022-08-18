package ru.mikhailin.coffeemachineapi.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class GetCoffeeRequestDTO {
    @NonNull
    private final LocalDateTime datetime;
    private final Integer fieldForResolveAnnotationConflict;
}
