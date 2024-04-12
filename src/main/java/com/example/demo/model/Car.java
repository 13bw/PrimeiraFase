package com.example.demo.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Document(collection = "cars")
public class Car {
    
    public Car(String name, String color, String model, int car_year) {
        this.name = name;
        this.color = color;
        this.model = model;
        this.car_year = car_year;
    }

    public Car() {}

    @Id
    private String id;

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
}
