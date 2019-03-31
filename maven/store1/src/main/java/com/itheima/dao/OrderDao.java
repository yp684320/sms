package com.itheima.dao;

import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.domain.vo.OrderItemVo;

import java.util.ArrayList;
import java.util.List;

public interface OrderDao {

    void saveOrder(Order order);

    void saveItem(OrderItem orderItem);

    Order findOrder(String oid);

    List<OrderItemVo> findOrderItemVos(String oid);

    int findTotal(String uid);

    List<Order> findMyOrders(String uid, int pageNumber, int pageSize);

    void updateShouhuoren(Order order);

    void updateState(String r6_order, int state);


}
