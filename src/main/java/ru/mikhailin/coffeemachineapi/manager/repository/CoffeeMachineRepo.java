package ru.mikhailin.coffeemachineapi.manager.repository;

import org.springframework.data.repository.CrudRepository;
import ru.mikhailin.coffeemachineapi.manager.entity.OrderEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface CoffeeMachineRepo extends CrudRepository<OrderEntity, Integer> {
    List<OrderEntity> findByReadyDateTime(LocalDateTime readyDateTime);
}
