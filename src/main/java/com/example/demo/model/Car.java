package com.example.demo.model;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity(name = "cars")
@Table(name = "cars")
public class Car {

    public Car(String name, String color, String model, int car_year, FuelType fuelType) {
        this.name = name;
        this.color = color;
        this.model = model;
        this.car_year = car_year;
        this.fuelType = fuelType;
    }

    public Car() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @NotBlank
    @Length(min = 5, max = 100)
    private String name;

    @NotNull
    @NotBlank
    @Length(min = 5, max = 20)
    private String color;

    @NotNull
    @NotBlank
    @Length(min = 5, max = 100)
    private String model;

    @NotNull
    @Positive
    private int car_year;

    @NotNull
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;
}
