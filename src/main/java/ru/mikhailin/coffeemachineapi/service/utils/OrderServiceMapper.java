package ru.mikhailin.coffeemachineapi.service.utils;

import ru.mikhailin.coffeemachineapi.controller.dto.request.CreateCoffeeRequestDTO;
import ru.mikhailin.coffeemachineapi.controller.dto.request.DeleteCoffeeRequestDTO;
import ru.mikhailin.coffeemachineapi.controller.dto.request.GetCoffeeRequestDTO;
import ru.mikhailin.coffeemachineapi.controller.dto.request.UpdateCoffeeRequestDTO;
import ru.mikhailin.coffeemachineapi.controller.dto.response.GetCoffeeResponseDTO;
import ru.mikhailin.coffeemachineapi.manager.entity.OrderEntity;

public interface OrderServiceMapper {
    OrderEntity toOrderEntity(CreateCoffeeRequestDTO requestDTO);
    OrderEntity toOrderEntity(DeleteCoffeeRequestDTO requestDTO);
    OrderEntity toOrderEntity(GetCoffeeRequestDTO requestDTO);
    OrderEntity toOrderEntity(UpdateCoffeeRequestDTO requestDTO);
    GetCoffeeResponseDTO toGetCoffeeResponseDTO(OrderEntity orderEntity);
}
