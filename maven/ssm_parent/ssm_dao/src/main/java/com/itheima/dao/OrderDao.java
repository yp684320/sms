package com.itheima.dao;

import com.itheima.domain.Order;
import com.itheima.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderDao {
    //查询所有
    @Select("select * from orders")
    @Results({
            @Result(property = "product", column = "productid", javaType = Product.class,
            one = @One(select = "com.itheima.dao.ProductDao.findById" ))
    })
    List<Order> findAll();
    //添加数据
   /* @Insert("insert into orders values(order_seq.nextval,#{orderNum},#{orderTime},#{peopleCount},#{orderDesc},#{payType},#{orderStatus},#{product.id})")*/

    @Insert("insert into orders values(#{id},#{orderNum},#{orderTime},#{peopleCount},#{orderDesc},#{payType},#{orderStatus},#{product.id})")
    /*keyProperty:主键属性名
    keyColumn:主键列名
    resultType:主键的类型
    before:在添加之前还是添加之后获取主键值
    statement:执行的sql语句
           mysql: select last_insert_id();
           oracle: select 序列名 from dual
    * */
    @SelectKey(keyProperty ="id" ,keyColumn ="id" ,resultType =Long.class ,before = true,statement ="select order_seq.nextval from dual" )
    void save(Order order);


}
