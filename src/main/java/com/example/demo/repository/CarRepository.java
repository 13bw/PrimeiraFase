package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Car;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    Page<Car> findAll(Pageable pageable);
}
