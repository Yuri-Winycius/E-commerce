package com.winy.e_commerce.ifrastructure.repositories;

import com.winy.e_commerce.ifrastructure.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
