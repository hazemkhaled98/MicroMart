package com.micromart.product.mapper;


import com.micromart.product.dto.ProductRequestDTO;
import com.micromart.product.dto.ProductResponseDTO;
import com.micromart.product.model.Product;

import java.util.List;

public class ProductMapper {

    private ProductMapper() {}

    public static Product toProduct(ProductRequestDTO dto){
        return Product
                .builder()
                .name(dto.name())
                .description(dto.description())
                .price(dto.price())
                .build();
    }

    public static ProductResponseDTO toResponseDTO(Product product){
        return ProductResponseDTO
                .builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public static List<ProductResponseDTO> toResponseDTO(List<Product> products){
        return products
                .stream()
                .map(ProductMapper::toResponseDTO)
                .toList();
    }


}
