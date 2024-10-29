package com.micromart.order.mapper;

import com.micromart.order.dto.OrderRequestDTO;
import com.micromart.order.dto.OrderResponseDTO;
import com.micromart.order.model.Order;

public class OrderMapper {


    private OrderMapper() {}


    public static Order toOrder(OrderRequestDTO requestDTO){
        return Order.builder()
                .skuCode(requestDTO.skuCode())
                .quantity(requestDTO.quantity())
                .price(requestDTO.price())
                .build();
    }


    public static OrderResponseDTO toResponseDTO(Order order){
        return OrderResponseDTO.builder()
                .id(order.getId())
                .skuCode(order.getSkuCode())
                .quantity(order.getQuantity())
                .price(order.getPrice())
                .build();
    }
}
