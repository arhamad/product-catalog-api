package edu.qou.product.catalog.api.service.impl;

import edu.qou.product.catalog.api.model.dto.ProductResponseDto;
import edu.qou.product.catalog.api.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("multiNotification")
@Slf4j
public class MultiNotificationService implements NotificationService {

    private final NotificationService emailNotificationService;

    private final NotificationService smsNotificationService;

    private final NotificationService pushNotificationService;

    public MultiNotificationService(
            @Qualifier("emailNotification") NotificationService emailNotificationService,
            @Qualifier("smsNotification") NotificationService smsNotificationService,
            @Qualifier("pushNotification") NotificationService pushNotificationService
    ) {
        this.emailNotificationService = emailNotificationService;
        this.smsNotificationService = smsNotificationService;
        this.pushNotificationService = pushNotificationService;
    }

    @Override
    public void notifyProductCreated(ProductResponseDto product) {
        log.info("=== Sending notifications through ALL channels ===");
        emailNotificationService.notifyProductCreated(product);
        smsNotificationService.notifyProductCreated(product);
        pushNotificationService.notifyProductCreated(product);
        log.info("=== All notifications sent ===");
    }

    @Override
    public void notifyProductUpdated(ProductResponseDto product) {
        log.info("=== Sending notifications through ALL channels ===");
        emailNotificationService.notifyProductUpdated(product);
        smsNotificationService.notifyProductUpdated(product);
        pushNotificationService.notifyProductUpdated(product);
        log.info("=== All notifications sent ===");
    }

    @Override
    public void notifyProductDeleted(Long productId) {
        log.info("=== Sending notifications through ALL channels ===");
        emailNotificationService.notifyProductDeleted(productId);
        smsNotificationService.notifyProductDeleted(productId);
        pushNotificationService.notifyProductDeleted(productId);
        log.info("=== All notifications sent ===");
    }
}
