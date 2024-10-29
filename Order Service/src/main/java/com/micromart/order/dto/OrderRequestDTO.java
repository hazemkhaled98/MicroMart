package com.micromart.order.dto;

import java.math.BigDecimal;

public record OrderRequestDTO(String skuCode, BigDecimal price, int quantity) {
}
