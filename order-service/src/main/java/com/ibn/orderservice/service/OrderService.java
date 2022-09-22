package com.ibn.orderservice.service;

import com.ibn.orderservice.dto.OrderRequest;
import com.ibn.orderservice.dto.OrderResponse;

import java.util.List;

public interface OrderService {

    void saveOrder(OrderRequest orderRequest);

    List<OrderResponse> getAllOrders();
}
