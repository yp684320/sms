package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.ProductDao;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;
    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productDao.findById(id);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void delById(Integer id) {
        productDao.delById(id);
    }

    @Override
    public void delMany(Integer[] ids) {
        //判断ids是否为空
        if (ids!=null) {
            for (Integer id : ids) {
                productDao.delById(id);
            }
        }

    }

    @Override
    public PageBean<Product> findByPage(Integer pageNum, Integer pageSize) {
        //创建一个PageBean对象
        PageBean<Product> pageBean = new PageBean<>();
        //PageBean的封装
        //当前页 (页面传参)
        pageBean.setPageNum(pageNum);
        //每页显示条数  (页面传参)
        pageBean.setPageSize(pageSize);
        //总条数
        Integer totalCount = productDao.findTotalCount();
        pageBean.setTotalCount(totalCount);
        //总页数  (计算得来:Math.ceil( totalCount * 1.0/pageSize) )
        pageBean.setTotalPage((int)Math.ceil(totalCount * 1.0 / pageSize));
        //当前页展示的数据
        /**
         * mysql： limit  m,n;
         *      m: 起始索引 n ：每页条数
         * oracle: -- rownum
         *   每页显示5条数据
         *      起始行号   结束行号
         * 第一页： 1         5
         * 第二页： 6         10
         * 第三页： 11        15
         * 第n页： 5 * n - 4           5 * n
         *        pageSize * pageNum - (pageSize - 1)   pageSize * pageNum
         *        pageSize * pageNum - pageSize +1
         *        pageSize(pageNum -1) + 1
         */
        Integer startNum = pageNum * pageSize - (pageSize - 1);
        Integer endNum = pageNum * pageSize;
       List<Product> products =productDao.findByPage(startNum , endNum);
        pageBean.setList(products);
        return pageBean;
    }

    @Override
    public PageInfo<Product> findByPageHelper(Integer pageNum, Integer pageSize) {
        //1, 指定分页初始化参数
        PageHelper.startPage(pageNum,pageSize);
        //2, 查询所有
        List<Product> products = productDao.findAll();
        //3, 创建PageInfo对象
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        return pageInfo;
    }

    @Override
    public void testFindByPageHelper(Integer pageNum, Integer pageSize) {
        //1, 指定分页初始化参数
        PageHelper.startPage(pageNum,pageSize);
        //2, 查询所有
        List<Product> products = productDao.findAll();
        System.out.println(products.size());
    }
}
