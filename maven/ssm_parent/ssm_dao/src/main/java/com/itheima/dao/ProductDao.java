package com.itheima.dao;

import com.itheima.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProductDao {
    //查询所有
    @Select("select * from product")
    List<Product> findAll();
    //添加数据
    @Insert("insert into product values(product_seq.nextval, #{productNum},#{productName} ,#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
    //通过id查询
    @Select("select p.* ,to_char(p.departureTime ,'yyyy-mm-dd') departureTimeStr from product p where id = #{id}")
    Product findById(Integer id);
    //更新数据
    @Update("update product set productNum=#{productNum},productName=#{productName} ,cityName=#{cityName},departureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where id = #{id}")
    void update(Product product);
    //删除有个
    @Delete("delete from product where id = #{id}")
    void delById(Integer id);


    //分页查询  获取总条数
     @Select("select count(1) from product")
    Integer findTotalCount();
    //分页查询  根据分页参数查询
    @Select("select t.* from (select p.*,rownum rn from product p) t where t.rn between #{param1} and #{param2}")

    List<Product> findByPage(Integer startNum, Integer endNum);
}
