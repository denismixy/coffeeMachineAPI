package ru.mikhailin.coffeemachineapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mikhailin.coffeemachineapi.controller.dto.request.CreateCoffeeRequestDTO;
import ru.mikhailin.coffeemachineapi.controller.dto.request.DeleteCoffeeRequestDTO;
import ru.mikhailin.coffeemachineapi.controller.dto.request.GetCoffeeRequestDTO;
import ru.mikhailin.coffeemachineapi.controller.dto.request.UpdateCoffeeRequestDTO;
import ru.mikhailin.coffeemachineapi.controller.dto.response.GetCoffeeResponseDTO;
import ru.mikhailin.coffeemachineapi.service.CoffeeMachineService;

import java.util.List;

@Tag(name = "API для использования кофеварки")
@RestController
@RequestMapping("/api/v0/smartHome/coffeeMachine/")
public class CoffeeMachineAPIController {

    @Autowired
    CoffeeMachineService coffeeMachineService;

    @Operation(summary = "Заказ кофе")
    @PostMapping("coffee")
    HttpStatus createCoffee(@RequestBody CreateCoffeeRequestDTO requestDTO) {
        return coffeeMachineService.createCoffee(requestDTO);
    }

    @Operation(summary = "Отмена заказанного кофе")
    @DeleteMapping("coffee")
    HttpStatus deleteCoffee(@RequestBody DeleteCoffeeRequestDTO requestDTO) {
        return coffeeMachineService.deleteCoffee(requestDTO);
    }

    @Operation(summary = "Получение информации о заказанном кофе")
    @GetMapping("coffee")
    ResponseEntity<List<GetCoffeeResponseDTO>> getCoffee(@RequestBody GetCoffeeRequestDTO requestDTO) {
        return coffeeMachineService.getCoffee(requestDTO);
    }

    @Operation(summary = "Получение списка заказанных кофе")
    @GetMapping("coffeeList")
    ResponseEntity<List<GetCoffeeResponseDTO>> getAllCoffee() {
        return coffeeMachineService.getAllCoffee();
    }

    @Operation(summary = "Редактировать заказ")
    @PatchMapping("coffee")
    HttpStatus updateCoffee(@RequestBody UpdateCoffeeRequestDTO requestDTO) {
        return coffeeMachineService.updateCoffee(requestDTO);
    }
}
