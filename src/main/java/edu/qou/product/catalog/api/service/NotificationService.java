package edu.qou.product.catalog.api.service;

import edu.qou.product.catalog.api.model.dto.ProductResponseDto;

public interface NotificationService {
    void notifyProductCreated(ProductResponseDto product);
    void notifyProductUpdated(ProductResponseDto product);
    void notifyProductDeleted(Long productId);
}
