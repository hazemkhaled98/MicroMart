package com.micromart.order.service;


import com.micromart.order.dto.OrderRequestDTO;
import com.micromart.order.dto.OrderResponseDTO;
import com.micromart.order.mapper.OrderMapper;
import com.micromart.order.model.Order;
import com.micromart.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {


    private final OrderRepository orderRepository;


    public String createOrder(OrderRequestDTO orderRequestDTO) {
        Order order = OrderMapper.toOrder(orderRequestDTO);
        Order createdOrder = orderRepository.save(order);
        log.info("Order created: " + createdOrder);
        return "Order created successfully";
    }
}
