package com.winy.e_commerce.controller;

import com.winy.e_commerce.infrastructure.entities.OrderEntity;
import com.winy.e_commerce.infrastructure.entities.ProductEntity;
import com.winy.e_commerce.infrastructure.entities.UserEntity;
import com.winy.e_commerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestParam("userId") UserEntity userId,
                                            @RequestParam("products") List<ProductEntity> products) {
        orderService.createOrder(userId, products);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderEntity> getOrderById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(orderService.findOrderById(id));
    }

    @GetMapping
    public ResponseEntity<List<OrderEntity>> findOrders() {
        return ResponseEntity.ok(orderService.findOrder());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable(name = "id") Long id) {
        orderService.deleteOrderById(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> changeOrderBy(@RequestParam(name = "id") Long id,
                                             @RequestBody OrderEntity order) {
        orderService.changeOrderById(id, order);

        return ResponseEntity.ok().build();
    }

}
