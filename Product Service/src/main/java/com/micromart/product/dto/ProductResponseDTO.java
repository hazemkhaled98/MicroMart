package com.micromart.product.dto;

import lombok.Builder;

import java.math.BigDecimal;


@Builder
public record ProductResponseDTO(String id, String name, String description, BigDecimal price) {
}
