package com.winy.e_commerce.ifrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_value")
    private BigDecimal totalValue;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToOne
    @JoinColumn(name = "products")
    private List<ProductEntity> products;

}
