package edu.qou.product.catalog.api.model.dto;

import edu.qou.product.catalog.api.model.enums.ProductCategory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductResponseDto (
    Long id,
    String name,
    String description,
    BigDecimal price,
    Integer stock,
    ProductCategory category,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) { }
