package com.itheima.service.impl;

import com.itheima.dao.OrderDao;
import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.domain.PageBean;
import com.itheima.domain.vo.OrderItemVo;
import com.itheima.service.OrderService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.C3P0Utils;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = BeanFactory.newInstance(OrderDao.class);
    @Override
    public void save(Order order, ArrayList<OrderItem> orderItems) {
        //添加事务操作

        //先开启事务
        try {
            C3P0Utils.beginTransaction();

            //先保存订单
            orderDao.saveOrder(order);
            //int i=5/0;
            //再保存订单项
            for (OrderItem orderItem : orderItems) {
                orderDao.saveItem(orderItem);
            }



            //成功提交事务
            C3P0Utils.commitAndClose();

        } catch (SQLException e) {
            e.printStackTrace();
            //失败回滚事务
            C3P0Utils.rollbackAndClose();
        }

    }

    @Override
    public Order findOrderWithItems(String oid) {
        //不仅仅要订单信息
        Order order = orderDao.findOrder(oid);
        //光秃秃的order信息  不够的
        //还要订单中 关联的订单项信息
        List<OrderItemVo> vos = orderDao.findOrderItemVos(oid);
        order.setVos(vos);
        return order;
    }

    @Override
    public void updateShouhuoren(Order order) {
        orderDao.updateShouhuoren(order);
    }

    @Override
    public void updateState(String r6_order, int state) {
        orderDao.updateState(r6_order,state);
    }

    @Override
    public PageBean<Order> findMyOrders(String uid, int pageNumber, int pageSize) {
        PageBean<Order> pageBean = new PageBean<>();


        pageBean.setPageNumber(pageNumber);

        pageBean.setPageSize(pageSize);


        //查询某个订单当前页的订单集合
        //在开发 有可能 完成某些任务 逻辑的时候  会在方法中 分步骤实现
        //
        List<Order> orders=this.findMyOrders0(uid,pageNumber,pageSize);
        //List<Order> myOrders = orderDao.findMyOrders(uid, pageNumber, pageSize);
        pageBean.setData(orders);

        int count=orderDao.findTotal(uid);
        pageBean.setTotal(count);


        return pageBean;
    }

    private List<Order> findMyOrders0(String uid, int pageNumber, int pageSize) {
        //完成查询某个订单当前页的数据的
        List<Order> myOrders = orderDao.findMyOrders(uid, pageNumber, pageSize);

        //还要订单项
        for (Order myOrder : myOrders) {
            List<OrderItemVo> vos=orderDao.findOrderItemVos(myOrder.getOid());

            myOrder.setVos(vos);
        }



        //返回的订单列表中 包含了订单项
        return myOrders;
    }


}
