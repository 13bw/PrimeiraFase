package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.dto.CarDTO;
import com.example.demo.dto.CarMapper;
import com.example.demo.dto.CarPageDTO;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Service
@Validated
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarMapper carMapper;

    public CarPageDTO listAll(@PositiveOrZero int page, @Positive @Max(100) int pageSize) {

        Page<Car> cars = carRepository.findAll(PageRequest.of(page, pageSize));
        List<CarDTO> carsDTO = cars.stream().map(car -> new CarMapper().toDTO(car)).toList(); 
        return new CarPageDTO(carsDTO, cars.getTotalPages(), cars.getTotalElements());

    }

    public CarDTO create(CarDTO carDTO) {
        Car car = carMapper.toModel(carDTO);
        car = carRepository.save(car);
        return carMapper.toDTO(car);
    }

    public CarDTO update(UUID id, CarDTO carDTO) {
        return carRepository.findById(id).map(car -> {
            car.setName(carDTO.name());
            car.setColor(carDTO.color());
            car.setModel(carDTO.model());
            car.setFuelType(carDTO.fuelType());
            car.setCar_year(carDTO.car_year());
            return carMapper.toDTO(carRepository.save(car));
        }).orElseThrow( () -> new RecordNotFoundException(id));
    }

    public void delete(UUID id) {
        carRepository.delete(carRepository.findById(id).orElseThrow( () -> new RecordNotFoundException(id)));
    }

    public CarDTO getById(UUID id) {
        return carRepository.findById(id).map(carMapper::toDTO).orElseThrow(() -> new RecordNotFoundException(id));
    }
}
