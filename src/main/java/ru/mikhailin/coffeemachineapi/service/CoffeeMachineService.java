package ru.mikhailin.coffeemachineapi.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.mikhailin.coffeemachineapi.controller.dto.request.CreateCoffeeRequestDTO;
import ru.mikhailin.coffeemachineapi.controller.dto.request.DeleteCoffeeRequestDTO;
import ru.mikhailin.coffeemachineapi.controller.dto.request.GetCoffeeRequestDTO;
import ru.mikhailin.coffeemachineapi.controller.dto.request.UpdateCoffeeRequestDTO;
import ru.mikhailin.coffeemachineapi.controller.dto.response.GetCoffeeResponseDTO;

import java.util.List;

public interface CoffeeMachineService {
    HttpStatus createCoffee(CreateCoffeeRequestDTO requestDTO);
    HttpStatus deleteCoffee(DeleteCoffeeRequestDTO requestDTO);
    ResponseEntity<List<GetCoffeeResponseDTO>> getCoffee(GetCoffeeRequestDTO requestDTO);
    ResponseEntity<List<GetCoffeeResponseDTO>> getAllCoffee();
    HttpStatus updateCoffee(UpdateCoffeeRequestDTO requestDTO);
}
