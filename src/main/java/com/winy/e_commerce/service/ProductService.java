package com.winy.e_commerce.service;

import com.winy.e_commerce.infrastructure.entities.ProductEntity;
import com.winy.e_commerce.infrastructure.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductEntity product) {
        productRepository.save(product);
    }

    public ProductEntity findProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() ->
                new NullPointerException("Product not find by id " + id));
    }

    @Transactional
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public void changeProductById(Long id, ProductEntity product) {
        ProductEntity newProduct = findProductById(id);
        product.setId(newProduct.getId());

        productRepository.save(product);
    }

}
