package edu.qou.product.catalog.api.model.mapper;

import edu.qou.product.catalog.api.model.dto.ProductRequestDto;
import edu.qou.product.catalog.api.model.dto.ProductResponseDto;
import edu.qou.product.catalog.api.model.entity.Product;

public interface ProductMapper {
    Product toEntity(ProductRequestDto dto);
    ProductResponseDto toResponseDto(Product entity);
    void updateEntityFromDto(ProductRequestDto dto, Product entity);
}
