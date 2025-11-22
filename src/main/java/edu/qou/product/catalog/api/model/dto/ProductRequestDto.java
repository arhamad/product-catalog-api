package edu.qou.product.catalog.api.model.dto;

import edu.qou.product.catalog.api.model.enums.ProductCategory;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductRequestDto (
    @NotBlank(message = "Product name is required")
    @Size(min = 3, max = 100, message = "Product name must be between 3 and 100 characters")
    String name,

    @Size(max = 500, message = "Description must not exceed 500 characters")
    String description,

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    @Digits(integer = 10, fraction = 2, message = "Price must have maximum 10 integer digits and 2 decimal places")
    BigDecimal price,

    @NotNull(message = "Stock is required")
    @Min(value = 0, message = "Stock cannot be negative")
    Integer stock,

    @NotNull(message = "Category is required")
    ProductCategory category
)
{ }
