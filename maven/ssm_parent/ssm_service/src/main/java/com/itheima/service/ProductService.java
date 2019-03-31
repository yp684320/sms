package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(Integer id);

    void update(Product product);

    void delById(Integer id);

    void delMany(Integer[] ids);
    //根据分页参数查询
    PageBean<Product> findByPage(Integer pageNum , Integer pageSize);
    //分页助手分页查询
    PageInfo<Product> findByPageHelper(Integer pageNum , Integer pageSize);
    //测试分页助手
    public void testFindByPageHelper(Integer pageNum , Integer pageSize);
}
