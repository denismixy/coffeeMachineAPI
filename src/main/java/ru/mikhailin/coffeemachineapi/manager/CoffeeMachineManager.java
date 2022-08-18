package ru.mikhailin.coffeemachineapi.manager;

import org.springframework.http.HttpStatus;
import ru.mikhailin.coffeemachineapi.manager.entity.OrderEntity;

import java.util.List;

public interface CoffeeMachineManager {
    HttpStatus createCoffee(OrderEntity order);
    HttpStatus deleteCoffee(OrderEntity order);
    List<OrderEntity> getCoffee(OrderEntity order);
    List<OrderEntity> getAllCoffee();
    HttpStatus updateCoffee(OrderEntity order);
}
