package com.winy.e_commerce.infrastructure.repositories;

import com.winy.e_commerce.infrastructure.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
