package com.itheima.service;

import com.itheima.domain.PageBean;
import com.itheima.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> findHots();

    List<Product> findNews();

    Product findOne(String pid);

    List<Product> findByPageWithCid(String cid, int pageNumber, int pageSize);

    PageBean<Product> findByPageWithCid4PB(String cid, int pageNumber, int pageSize);


}
