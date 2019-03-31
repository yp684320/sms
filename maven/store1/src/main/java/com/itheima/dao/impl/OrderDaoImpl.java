package com.itheima.dao.impl;

import com.itheima.dao.OrderDao;
import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.domain.vo.OrderItemVo;
import com.itheima.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;


public class OrderDaoImpl implements OrderDao{

    @Override
    public void saveOrder(Order order) {
        QueryRunner qr = new QueryRunner();
        /**
         *  // 订单id
         private String oid;
         // 订单时间
         private Date ordertime;
         // 订单金额
         private Double total;

         // 订单状态
         private Integer state;// 订单状态 0:未付款 1:已付款 2:已发货 3.已完成
         // 收获地址
         private String address;
         // 收货人姓名
         private String name;

         // 收获人电话
         private String telephone;
         private String uid;

         */
        String sql="insert into orders values(?,?,?,?,?,?,?,?)";


        try {
            qr.update(
                    C3P0Utils.getConnection(),
                    sql,
                    order.getOid(),order.getOrdertime(),order.getTotal(),
                    order.getState(),order.getAddress(),order.getName(),order.getTelephone(),order.getUid()
            );
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveItem(OrderItem orderItem) {
        QueryRunner qr = new QueryRunner();
        /**
         * //订单项数量
         private Integer count;
         //订单项小计
         private Double subTotal;
         private String pid;
         private String oid;


         */
        String sql="insert into orderitem values(?,?,?,?)";


        try {
            qr.update(
                    C3P0Utils.getConnection(),
                    sql,
                    orderItem.getCount(),orderItem.getSubTotal(),orderItem.getPid(),orderItem.getOid()

            );
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Order findOrder(String oid) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        String sql="select * from orders where oid=? ";


        try {
            return qr.query(sql,new BeanHandler<>(Order.class),oid);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<OrderItemVo> findOrderItemVos(String oid) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        String sql=
                "SELECT oi.count, oi.subtotal,oi.pid,oi.oid,p.pname,p.shop_price,p.pimage FROM orderitem oi ,product p WHERE oi.pid=p.pid AND oid=? ";


        try {
            return qr.query(sql,new BeanListHandler<>(OrderItemVo.class),oid);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public int findTotal(String uid) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        String sql="select count(*) from orders where uid=?";

        try {
            return ((Long)qr.query(sql,new ScalarHandler(),uid)).intValue();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> findMyOrders(String uid, int pageNumber, int pageSize) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        String sql="select * from orders where uid=? limit ?,?";

        try {
            return qr.query(sql,new BeanListHandler<>(Order.class),uid,(pageNumber-1)*pageSize,pageSize);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateShouhuoren(Order order) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        String sql="update orders set  name=? , address=?,telephone=? where oid=?";

        try {
            qr.update(sql,order.getName(),order.getAddress(),order.getTelephone(),order.getOid());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    @Override
    public void updateState(String oid, int state) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        String sql="update orders set  state=?  where oid=?";

        try {
            qr.update(sql,state, oid);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

