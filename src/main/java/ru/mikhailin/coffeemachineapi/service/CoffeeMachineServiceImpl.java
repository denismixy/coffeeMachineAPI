package ru.mikhailin.coffeemachineapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ru.mikhailin.coffeemachineapi.controller.dto.request.CreateCoffeeRequestDTO;
import ru.mikhailin.coffeemachineapi.controller.dto.request.DeleteCoffeeRequestDTO;
import ru.mikhailin.coffeemachineapi.controller.dto.request.GetCoffeeRequestDTO;
import ru.mikhailin.coffeemachineapi.controller.dto.request.UpdateCoffeeRequestDTO;
import ru.mikhailin.coffeemachineapi.controller.dto.response.GetCoffeeResponseDTO;
import ru.mikhailin.coffeemachineapi.manager.CoffeeMachineManager;
import ru.mikhailin.coffeemachineapi.service.utils.OrderServiceMapper;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CoffeeMachineServiceImpl implements CoffeeMachineService {

    @Autowired
    CoffeeMachineManager coffeeMachineManager;

    @Autowired
    OrderServiceMapper orderServiceMapper;

    @Override
    public HttpStatus createCoffee(CreateCoffeeRequestDTO requestDTO) {
        return coffeeMachineManager.createCoffee(orderServiceMapper.toOrderEntity(requestDTO));
    }

    @Override
    public HttpStatus deleteCoffee(DeleteCoffeeRequestDTO requestDTO) {
        return coffeeMachineManager.deleteCoffee(orderServiceMapper.toOrderEntity(requestDTO));
    }

    @Override
    public ResponseEntity<List<GetCoffeeResponseDTO>> getCoffee(GetCoffeeRequestDTO requestDTO) {
        List<GetCoffeeResponseDTO> responseDTOList = coffeeMachineManager.getCoffee(orderServiceMapper.toOrderEntity(requestDTO))
                .stream()
                .map(objectMap -> orderServiceMapper.toGetCoffeeResponseDTO(objectMap))
                .collect(Collectors.toList());
        if (responseDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(responseDTOList, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<List<GetCoffeeResponseDTO>> getAllCoffee() {
        List<GetCoffeeResponseDTO> responseDTOList = coffeeMachineManager.getAllCoffee()
                                .stream()
                                .map(objectMap -> orderServiceMapper.toGetCoffeeResponseDTO(objectMap))
                                .collect(Collectors.toList());
        if (responseDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(responseDTOList, HttpStatus.OK);
        }
    }

    @Override
    public HttpStatus updateCoffee(UpdateCoffeeRequestDTO requestDTO) {
        return coffeeMachineManager.updateCoffee(orderServiceMapper.toOrderEntity(requestDTO));
    }
}
