package edu.qou.product.catalog.api.service.impl;

import edu.qou.product.catalog.api.model.dto.ProductResponseDto;
import edu.qou.product.catalog.api.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("smsNotification")
@Slf4j
public class SmsNotificationService implements NotificationService {
    @Override
    public void notifyProductCreated(ProductResponseDto product) {
        log.info("📱 SMS NOTIFICATION: Product Created");
        log.info("To: +1234567890");
        log.info("Message: New product '{}' added! ID: {}, Price: ${}",
                product.name(), product.id(), product.price());
        System.out.println("✅ SMS sent successfully!");
    }

    @Override
    public void notifyProductUpdated(ProductResponseDto product) {
        log.info("📱 SMS NOTIFICATION: Product Updated");
        log.info("To: +1234567890");
        log.info("Message: Product '{}' (ID: {}) updated. New price: ${}",
                product.name(), product.id(), product.price());
        System.out.println("✅ SMS sent successfully!");
    }

    @Override
    public void notifyProductDeleted(Long productId) {
        log.info("📱 SMS NOTIFICATION: Product Deleted");
        log.info("To: +1234567890");
        log.info("Message: Product ID {} has been deleted.", productId);
        System.out.println("✅ SMS sent successfully!");
    }
}
