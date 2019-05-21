package com.example.demo.core;

import com.example.demo.entity.Order;

public interface OrderMessagingService {

    void sendOrder(Order order);
}
