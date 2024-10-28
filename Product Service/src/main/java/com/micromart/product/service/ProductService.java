package com.micromart.product.service;


import com.micromart.product.dto.ProductRequestDTO;
import com.micromart.product.dto.ProductResponseDTO;
import com.micromart.product.mapper.ProductMapper;
import com.micromart.product.model.Product;
import com.micromart.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;


    public Product createProduct(ProductRequestDTO requestDTO) {
        Product newProduct = ProductMapper.toProduct(requestDTO);
        Product createdProduct = productRepository.save(newProduct);
        log.info("Product created: {}", createdProduct);
        return createdProduct;
    }


    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDTO> responseDTO = ProductMapper.toResponseDTO(products);
        log.info("Products retrieved");
        return responseDTO;
    }
}
