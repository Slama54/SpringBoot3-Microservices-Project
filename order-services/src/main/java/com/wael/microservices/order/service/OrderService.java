package com.wael.microservices.order.service;

import com.wael.microservices.order.dto.OrderRequest;
import com.wael.microservices.order.model.Order;
import com.wael.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private  final OrderRepository orderRepository;

    public  void placeOrder(OrderRequest orderRequest){
        // Map OrderRequest to Order object
        Order order =  new  Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());

        // Save order to OrderRepository
        orderRepository.save(order);


    }
}
