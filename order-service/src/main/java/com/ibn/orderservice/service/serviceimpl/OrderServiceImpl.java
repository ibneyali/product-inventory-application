package com.ibn.orderservice.service.serviceimpl;

import com.ibn.orderservice.dto.OrderLineItemsDto;
import com.ibn.orderservice.dto.OrderRequest;
import com.ibn.orderservice.dto.OrderResponse;
import com.ibn.orderservice.model.Order;
import com.ibn.orderservice.model.OrderLineItems;
import com.ibn.orderservice.repository.OrderRepository;
import com.ibn.orderservice.service.OrderService;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@Builder
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;


    @Override
    public void saveOrder(OrderRequest orderRequest) {

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream().map(this :: mapToOrderRequest).toList();
        order.setOrderLineItemsList(orderLineItems);
        orderRepository.save(order);
    }

    private OrderLineItems mapToOrderRequest(OrderLineItemsDto orderLineItemsDto) {

        return OrderLineItems.builder()
                        .price(orderLineItemsDto.getPrice())
                                .quantity(orderLineItemsDto.getQuantity())
                                        .skuCode(orderLineItemsDto.getSkuCode())
                                                .build();
    }
    @Override
    public List<OrderResponse> getAllOrders() {

        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(this :: mapToOrderResponse).toList();
    }
    private OrderResponse mapToOrderResponse(Order order) {

        OrderResponse or = new OrderResponse();
        List<OrderLineItemsDto> orderDto = order.getOrderLineItemsList()
                .stream().map(this :: mapToOrderLineListDto).toList();
        return OrderResponse.builder()
                        .orderNumber(order.getOrderNumber())
                                .orderLineItemsDtoList(orderDto)
                                        .build();
    }

    private OrderLineItemsDto mapToOrderLineListDto(OrderLineItems orderLineItems) {

        return OrderLineItemsDto.builder()
                .skuCode(orderLineItems.getSkuCode())
                        .price(orderLineItems.getPrice())
                                .quantity(orderLineItems.getQuantity())
                                        .build();


    }

}
