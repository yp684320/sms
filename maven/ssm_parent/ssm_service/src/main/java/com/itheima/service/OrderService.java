package com.itheima.service;

import com.itheima.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    void save(Order order);
}
