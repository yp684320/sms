package com.itheima.service;

import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.domain.PageBean;

import java.util.ArrayList;

public interface OrderService {
    void save(Order order, ArrayList<OrderItem> orderItems);

    Order findOrderWithItems(String oid);

    void updateShouhuoren(Order order);

    void updateState(String r6_order, int orderStateYifukuan);

    PageBean<Order> findMyOrders(String uid, int pageNumber, int pageSize);
}
