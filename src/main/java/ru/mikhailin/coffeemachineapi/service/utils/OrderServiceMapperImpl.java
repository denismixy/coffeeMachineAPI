package ru.mikhailin.coffeemachineapi.service.utils;

import org.springframework.stereotype.Component;
import ru.mikhailin.coffeemachineapi.controller.dto.request.CreateCoffeeRequestDTO;
import ru.mikhailin.coffeemachineapi.controller.dto.request.DeleteCoffeeRequestDTO;
import ru.mikhailin.coffeemachineapi.controller.dto.request.GetCoffeeRequestDTO;
import ru.mikhailin.coffeemachineapi.controller.dto.request.UpdateCoffeeRequestDTO;
import ru.mikhailin.coffeemachineapi.controller.dto.response.GetCoffeeResponseDTO;
import ru.mikhailin.coffeemachineapi.manager.entity.OrderEntity;

import java.time.LocalDateTime;

@Component
public class OrderServiceMapperImpl implements OrderServiceMapper {

    @Override
    public OrderEntity toOrderEntity(CreateCoffeeRequestDTO requestDTO) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCustomerId(requestDTO.getCustomerId());
        orderEntity.setOrderDateTime(LocalDateTime.now());
        orderEntity.setReadyDateTime(requestDTO.getDatetime());
        return orderEntity;
    }

    @Override
    public OrderEntity toOrderEntity(DeleteCoffeeRequestDTO requestDTO) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(requestDTO.getOrderId());
        orderEntity.setCustomerId(requestDTO.getCustomerId());
        return orderEntity;
    }

    @Override
    public OrderEntity toOrderEntity(GetCoffeeRequestDTO requestDTO) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setReadyDateTime(requestDTO.getDatetime());
        return orderEntity;
    }

    @Override
    public OrderEntity toOrderEntity(UpdateCoffeeRequestDTO requestDTO) {
        return new OrderEntity(requestDTO.getOrderId(), LocalDateTime.now(), requestDTO.getDatetime(), requestDTO.getCustomerId());
    }

    @Override
    public GetCoffeeResponseDTO toGetCoffeeResponseDTO(OrderEntity orderEntity) {
        return new GetCoffeeResponseDTO(orderEntity.getId(), orderEntity.getReadyDateTime(), orderEntity.getCustomerId());
    }
}
