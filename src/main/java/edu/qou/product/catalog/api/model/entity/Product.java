package edu.qou.product.catalog.api.model.entity;

import edu.qou.product.catalog.api.model.enums.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private ProductCategory category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
