package com.example.demo.dto;

import java.util.UUID;

import com.example.demo.model.FuelType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CarDTO(
        UUID id,
        @NotNull @NotBlank String name,
        @NotNull @NotBlank String color,
        @NotNull @NotBlank String model,
        @NotNull @Positive int car_year,
        @NotNull FuelType fuelType) {

}
