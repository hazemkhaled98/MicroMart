package com.micromart.product.controller;


import com.micromart.product.dto.ProductRequestDTO;
import com.micromart.product.dto.ProductResponseDTO;
import com.micromart.product.model.Product;
import com.micromart.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/api/products"))
@RequiredArgsConstructor
public class Controller {


    private final ProductService productService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody ProductRequestDTO product) {
        return productService.createProduct(product);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDTO> getAllProducts() {
        return productService.getAllProducts();
    }

}
