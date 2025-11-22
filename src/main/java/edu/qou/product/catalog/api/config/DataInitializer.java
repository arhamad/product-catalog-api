package edu.qou.product.catalog.api.config;

import edu.qou.product.catalog.api.model.entity.Product;
import edu.qou.product.catalog.api.model.enums.ProductCategory;
import edu.qou.product.catalog.api.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;

    public DataInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("🚀 Initializing sample data...");

        // Electronics
        Product laptop = new Product(
                null,
                "Gaming Laptop",
                "High-performance laptop with RTX 4070 GPU",
                new BigDecimal("1499.99"),
                15,
                ProductCategory.ELECTRONICS,
                java.time.LocalDateTime.now(),
                java.time.LocalDateTime.now()
        );

        Product smartphone = new Product(
                null,
                "Smartphone Pro",
                "Latest flagship smartphone with 256GB storage",
                new BigDecimal("999.99"),
                50,
                ProductCategory.ELECTRONICS,
                java.time.LocalDateTime.now(),
                java.time.LocalDateTime.now()
        );

        Product headphones = new Product(
                null,
                "Wireless Headphones",
                "Noise-cancelling Bluetooth headphones",
                new BigDecimal("299.99"),
                30,
                ProductCategory.ELECTRONICS,
                java.time.LocalDateTime.now(),
                java.time.LocalDateTime.now()
        );

        // Books
        Product book1 = new Product(
                null,
                "Clean Code",
                "A Handbook of Agile Software Craftsmanship by Robert C. Martin",
                new BigDecimal("42.99"),
                100,
                ProductCategory.BOOKS,
                java.time.LocalDateTime.now(),
                java.time.LocalDateTime.now()
        );

        Product book2 = new Product(
                null,
                "Design Patterns",
                "Elements of Reusable Object-Oriented Software",
                new BigDecimal("54.99"),
                75,
                ProductCategory.BOOKS,
                java.time.LocalDateTime.now(),
                java.time.LocalDateTime.now()
        );

        // Clothing
        Product tshirt = new Product(
                null,
                "Cotton T-Shirt",
                "Comfortable 100% cotton t-shirt, available in multiple colors",
                new BigDecimal("19.99"),
                200,
                ProductCategory.CLOTHING,
                java.time.LocalDateTime.now(),
                java.time.LocalDateTime.now()
        );

        Product jeans = new Product(
                null,
                "Denim Jeans",
                "Classic fit denim jeans",
                new BigDecimal("59.99"),
                150,
                ProductCategory.CLOTHING,
                java.time.LocalDateTime.now(),
                java.time.LocalDateTime.now()
        );

        // Sports
        Product yogaMat = new Product(
                null,
                "Yoga Mat",
                "Non-slip exercise yoga mat with carrying strap",
                new BigDecimal("29.99"),
                80,
                ProductCategory.SPORTS,
                java.time.LocalDateTime.now(),
                java.time.LocalDateTime.now()
        );

        Product dumbbell = new Product(
                null,
                "Adjustable Dumbbell Set",
                "5-50 lbs adjustable dumbbell set",
                new BigDecimal("249.99"),
                25,
                ProductCategory.SPORTS,
                java.time.LocalDateTime.now(),
                java.time.LocalDateTime.now()
        );

        // Furniture
        Product desk = new Product(
                null,
                "Standing Desk",
                "Electric height-adjustable standing desk",
                new BigDecimal("399.99"),
                20,
                ProductCategory.FURNITURE,
                java.time.LocalDateTime.now(),
                java.time.LocalDateTime.now()
        );

        Product chair = new Product(
                null,
                "Ergonomic Office Chair",
                "Mesh back ergonomic chair with lumbar support",
                new BigDecimal("299.99"),
                35,
                ProductCategory.FURNITURE,
                java.time.LocalDateTime.now(),
                java.time.LocalDateTime.now()
        );

        // Food
        Product coffee = new Product(
                null,
                "Premium Coffee Beans",
                "Organic arabica coffee beans, 1kg",
                new BigDecimal("24.99"),
                120,
                ProductCategory.FOOD,
                java.time.LocalDateTime.now(),
                java.time.LocalDateTime.now()
        );

        // Save all products
        productRepository.save(laptop);
        productRepository.save(smartphone);
        productRepository.save(headphones);
        productRepository.save(book1);
        productRepository.save(book2);
        productRepository.save(tshirt);
        productRepository.save(jeans);
        productRepository.save(yogaMat);
        productRepository.save(dumbbell);
        productRepository.save(desk);
        productRepository.save(chair);
        productRepository.save(coffee);

        System.out.println("✅ Sample data initialized successfully!");
        System.out.println("📦 Total products: " + productRepository.findAll().size());
    }
}
