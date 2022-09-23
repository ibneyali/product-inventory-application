package com.ibn.orderservice.controller;

import com.ibn.orderservice.dto.OrderRequest;
import com.ibn.orderservice.dto.OrderResponse;
import com.ibn.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api")
@Transactional
public class OrderController {
    @Autowired
    OrderService orderService;
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        return orderService.saveOrder(orderRequest);
    }
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> getAllOrders(){
        return orderService.getAllOrders();
    }
}
