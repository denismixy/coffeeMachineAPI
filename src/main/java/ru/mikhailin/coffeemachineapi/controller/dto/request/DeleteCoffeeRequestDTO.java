package ru.mikhailin.coffeemachineapi.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class DeleteCoffeeRequestDTO {
    @NonNull
    private final Integer orderId;
    @NonNull
    private final Integer customerId;
}
