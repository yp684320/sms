package com.itheima.dao;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findHots();

    List<Product> findNews();

    Product findOne(String pid);

    List<Product> findByPageWithCid(String cid, int pageNumber, int pageSize);


    int findTotalByCid(String cid);
}
