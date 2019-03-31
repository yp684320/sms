package com.itheima.service.impl;

import com.itheima.dao.ProductDao;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.utils.BeanFactory;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = BeanFactory.newInstance(ProductDao.class);
    @Override
    public List<Product> findHots() {
        return productDao.findHots();
    }

    @Override
    public List<Product> findNews() {
        return productDao.findNews();
    }

    @Override
    public Product findOne(String pid) {
        return productDao.findOne(pid);
    }

    @Override
    public List<Product> findByPageWithCid(String cid, int pageNumber, int pageSize) {
        return productDao.findByPageWithCid(cid,pageNumber,pageSize);
    }

    @Override
    public PageBean<Product> findByPageWithCid4PB(String cid, int pageNumber, int pageSize) {
        //创建pagebean
        PageBean<Product> pb = new PageBean<>();
        pb.setPageNumber(pageNumber);
        pb.setPageSize(pageSize);
        //查询当前页数据
         List<Product> data = productDao.findByPageWithCid(cid ,pageNumber,pageSize);
         pb.setData(data);
         //查询当前页数据个数
       int count =  productDao.findTotalByCid(cid);
       pb.setTotal(count);
         return pb;
    }


}
