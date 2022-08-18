package ru.mikhailin.coffeemachineapi.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import ru.mikhailin.coffeemachineapi.manager.entity.OrderEntity;
import ru.mikhailin.coffeemachineapi.manager.repository.CoffeeMachineRepo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class CoffeeMachineManagerImpl implements CoffeeMachineManager {

    private static Logger logger = Logger.getLogger(CoffeeMachineManagerImpl.class.getName());

    @Autowired
    private CoffeeMachineRepo coffeeMachineRepo;

    @Override
    public HttpStatus createCoffee(OrderEntity order) {
        try {
            coffeeMachineRepo.save(order);
            return HttpStatus.OK;
        } catch (Exception exception) {
            logger.log(Level.SEVERE, exception.getMessage(), exception);
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @Override
    public HttpStatus deleteCoffee(OrderEntity order) {
        try {
            coffeeMachineRepo.delete(order);
            return HttpStatus.OK;
        } catch (Exception exception) {
            logger.log(Level.SEVERE, exception.getMessage(), exception);
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @Override
    public List<OrderEntity> getCoffee(OrderEntity order) {
        return coffeeMachineRepo.findByReadyDateTime(order.getReadyDateTime());
    }

    @Override
    public List<OrderEntity> getAllCoffee() {
        return (List<OrderEntity>) coffeeMachineRepo.findAll();
    }

    @Override
    public HttpStatus updateCoffee(OrderEntity order) {
        try {
            coffeeMachineRepo.save(order);
            return HttpStatus.OK;
        } catch (Exception exception) {
            logger.log(Level.SEVERE, exception.getMessage(), exception);
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
