package com.winy.e_commerce.service;

import com.winy.e_commerce.infrastructure.entities.OrderEntity;
import com.winy.e_commerce.infrastructure.entities.ProductEntity;
import com.winy.e_commerce.infrastructure.entities.UserEntity;
import com.winy.e_commerce.infrastructure.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final ProductService productService;

    private void createOrder(Long userId, List<ProductEntity> products) {
        UserEntity user = userService.findUserById(userId);
        BigDecimal totalValue = BigDecimal.ZERO;

        for (ProductEntity product : products) {
            totalValue = totalValue.add(product.getPrice());
        }

        OrderEntity order = OrderEntity.builder()
                .totalValue(totalValue)
                .orderDate(LocalDateTime.now())
                .userId(user.getId())
                .products(products)
                .build();

        orderRepository.save(order);
    }

    public OrderEntity findOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() ->
                new NullPointerException("Order not find by id " + id));
    }

    public List<OrderEntity> findOrder() {
        return orderRepository.findAll();
    }

    public void deleteOrderById(Long id){
        orderRepository.deleteById(id);
    }

    public void changeOrder(Long id, OrderEntity order) {
        OrderEntity newOrder = findOrderById(id);
        order.setId(newOrder.getId());

        orderRepository.save(order);
    }

}
