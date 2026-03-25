package com.winy.e_commerce.infrastructure.repositories;

import com.winy.e_commerce.infrastructure.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
