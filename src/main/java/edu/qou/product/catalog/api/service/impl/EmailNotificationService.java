package edu.qou.product.catalog.api.service.impl;

import edu.qou.product.catalog.api.model.dto.ProductResponseDto;
import edu.qou.product.catalog.api.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("emailNotification")
@Slf4j
public class EmailNotificationService implements NotificationService {
    @Override
    public void notifyProductCreated(ProductResponseDto product) {
        log.info("📧 EMAIL NOTIFICATION: Product Created");
        log.info("To: admin@example.com");
        log.info("Subject: New Product Added - {}", product.name());
        log.info("Body: A new product '{}' with ID {} has been created. Price: ${}",
                product.name(), product.id(), product.price());
        System.out.println("✅ Email sent successfully!");
    }

    @Override
    public void notifyProductUpdated(ProductResponseDto product) {
        log.info("📧 EMAIL NOTIFICATION: Product Updated");
        log.info("To: admin@example.com");
        log.info("Subject: Product Updated - {}", product.name());
        log.info("Body: Product '{}' with ID {} has been updated. New Price: ${}",
                product.name(), product.id(), product.price());
        System.out.println("✅ Email sent successfully!");
    }

    @Override
    public void notifyProductDeleted(Long productId) {
        log.info("📧 EMAIL NOTIFICATION: Product Deleted");
        log.info("To: admin@example.com");
        log.info("Subject: Product Deleted - ID: {}", productId);
        log.info("Body: Product with ID {} has been deleted from the catalog.", productId);
        System.out.println("✅ Email sent successfully!");
    }
}
