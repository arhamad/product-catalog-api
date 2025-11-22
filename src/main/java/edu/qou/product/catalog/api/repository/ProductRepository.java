package edu.qou.product.catalog.api.repository;

import edu.qou.product.catalog.api.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    boolean existsById(Long id);
    void deleteById(Long id);
}
