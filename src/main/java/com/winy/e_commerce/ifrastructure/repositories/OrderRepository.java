package com.winy.e_commerce.ifrastructure.repositories;

import com.winy.e_commerce.ifrastructure.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
