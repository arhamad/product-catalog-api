package edu.qou.product.catalog.api.service.impl;

import edu.qou.product.catalog.api.exception.ProductNotFoundException;
import edu.qou.product.catalog.api.model.dto.ProductRequestDto;
import edu.qou.product.catalog.api.model.dto.ProductResponseDto;
import edu.qou.product.catalog.api.model.entity.Product;
import edu.qou.product.catalog.api.model.mapper.ProductMapper;
import edu.qou.product.catalog.api.repository.ProductRepository;
import edu.qou.product.catalog.api.service.NotificationService;
import edu.qou.product.catalog.api.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    private final NotificationService notificationService;

    public ProductServiceImpl(
            ProductRepository productRepository,
            ProductMapper productMapper,
            @Qualifier("multiNotification") NotificationService notificationService
    ) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.notificationService = notificationService;
    }


    @Override
    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return productMapper.toResponseDto(product);
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Product product = productMapper.toEntity(requestDto);
        Product savedProduct = productRepository.save(product);
        ProductResponseDto responseDto = productMapper.toResponseDto(savedProduct);

        // Send notification after product creation
        notificationService.notifyProductCreated(responseDto);

        return responseDto;
    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto requestDto) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        productMapper.updateEntityFromDto(requestDto, existingProduct);
        Product updatedProduct = productRepository.save(existingProduct);
        ProductResponseDto responseDto = productMapper.toResponseDto(updatedProduct);

        // Send notification after product update
        notificationService.notifyProductUpdated(responseDto);

        return responseDto;
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);

        // Send notification after product deletion
        notificationService.notifyProductDeleted(id);
    }
}
