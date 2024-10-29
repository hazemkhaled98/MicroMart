package com.micromart.order.dto;

import lombok.Builder;

import java.math.BigDecimal;


@Builder
public record OrderResponseDTO(long id, String skuCode, BigDecimal price, int quantity) {
}
