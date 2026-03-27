package com.winy.e_commerce.controller;

import com.winy.e_commerce.infrastructure.entities.ProductEntity;
import com.winy.e_commerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductEntity product) {
        productService.createProduct(product);

        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> findProductById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable(name = "id") Long id) {
        productService.deleteProductById(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> changeProductBy(@RequestParam(name = "id") Long id,
                                                @RequestBody ProductEntity product) {
        productService.changeProductById(id, product);

        return ResponseEntity.ok().build();
    }

}
