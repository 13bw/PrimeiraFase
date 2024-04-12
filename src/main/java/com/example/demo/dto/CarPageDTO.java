package com.example.demo.dto;


import java.util.List;

public record CarPageDTO(List<CarDTO> content, int totalPages, long totalElements) {
}
