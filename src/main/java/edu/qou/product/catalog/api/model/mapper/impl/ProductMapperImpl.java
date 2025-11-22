package edu.qou.product.catalog.api.model.mapper.impl;

import edu.qou.product.catalog.api.model.dto.ProductRequestDto;
import edu.qou.product.catalog.api.model.dto.ProductResponseDto;
import edu.qou.product.catalog.api.model.entity.Product;
import edu.qou.product.catalog.api.model.mapper.ProductMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements ProductMapper {
    @Override
    public Product toEntity(ProductRequestDto dto) {
        if (dto == null) {
            return null;
        }

        Product product = new Product();
        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        product.setStock(dto.stock());
        product.setCategory(dto.category());
        product.setCreatedAt(java.time.LocalDateTime.now());
        product.setUpdatedAt(java.time.LocalDateTime.now());

        return product;
    }

    @Override
    public ProductResponseDto toResponseDto(Product entity) {
        if (entity == null) {
            return null;
        }

        return new ProductResponseDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getStock(),
                entity.getCategory(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    @Override
    public void updateEntityFromDto(ProductRequestDto dto, Product entity) {
        if (dto == null || entity == null) {
            return;
        }

        entity.setName(dto.name());
        entity.setDescription(dto.description());
        entity.setPrice(dto.price());
        entity.setStock(dto.stock());
        entity.setCategory(dto.category());
        entity.setUpdatedAt(java.time.LocalDateTime.now());
    }
}
