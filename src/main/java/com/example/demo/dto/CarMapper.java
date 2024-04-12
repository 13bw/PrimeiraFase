package com.example.demo.dto;

import org.springframework.stereotype.Service;

import com.example.demo.model.Car;

@Service
public class CarMapper {
    
    public CarDTO toDTO(Car car) {
        return new CarDTO(car.getId(), car.getName(), car.getColor(), car.getModel(), car.getCar_year());
    }

    public Car toModel(CarDTO carDTO) {
        return new Car(carDTO.name(), carDTO.color(), carDTO.model(), carDTO.car_year());
    }
}
