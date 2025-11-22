package edu.qou.product.catalog.api.service.impl;

import edu.qou.product.catalog.api.model.dto.ProductResponseDto;
import edu.qou.product.catalog.api.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("pushNotification")
@Slf4j
public class PushNotificationService implements NotificationService {
    @Override
    public void notifyProductCreated(ProductResponseDto product) {
        log.info("🔔 PUSH NOTIFICATION: Product Created");
        log.info("Device Token: abc123xyz789");
        log.info("Title: New Product Available!");
        log.info("Body: Check out '{}' - Now available for ${}",
                product.name(), product.price());
        System.out.println("✅ Push notification sent successfully!");
    }

    @Override
    public void notifyProductUpdated(ProductResponseDto product) {
        log.info("🔔 PUSH NOTIFICATION: Product Updated");
        log.info("Device Token: abc123xyz789");
        log.info("Title: Product Update");
        log.info("Body: '{}' has been updated. New price: ${}",
                product.name(), product.price());
        System.out.println("✅ Push notification sent successfully!");
    }

    @Override
    public void notifyProductDeleted(Long productId) {
        log.info("🔔 PUSH NOTIFICATION: Product Deleted");
        log.info("Device Token: abc123xyz789");
        log.info("Title: Product Removed");
        log.info("Body: Product ID {} is no longer available.", productId);
        System.out.println("✅ Push notification sent successfully!");
    }
}
