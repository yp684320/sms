package com.itheima.service.impl;


import com.itheima.dao.CategoryDao;
import com.itheima.dao.ProductDao;
import com.itheima.domain.Category;
import com.itheima.exception.CategoryHasProductException;
import com.itheima.service.CartService;
import com.itheima.service.CategoryService;
import com.itheima.service.ProductService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.RedisUtil;
import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
private CategoryDao categoryDao = BeanFactory.newInstance(CategoryDao.class);
private ProductDao productDao = BeanFactory.newInstance(ProductDao.class);
    @Override
    public List<Category> findAll() {
        //使用缓存
        //创建与redis数据库连接
        Jedis connection =null;
            try {
                connection =RedisUtil.getConnection();
                //获取category
                String category = connection.get("day21_category");
                //判断
                if (category == null) {
                    //缓存数据库没有 调用数据库查询
                    List<Category> all = categoryDao.findAll();
                    //缓存数据库里放一份  all是list集合 所以用JSONArray
                    connection.set("day21_category", JSONArray.fromObject(all).toString());
                    return all;
                } else {
                    //缓存数据库有
                    //category 就是缓存的json字符串
                    //在jsonlib工具类 提供了方法 可以将json字符串转换java对象
                    JSONArray jsonArray = JSONArray.fromObject(category);
                    List list = JSONArray.toList(jsonArray);
                    return list;
                }
            }
            finally{
                connection.close();
            }
        }

    @Override
    public void del(String cid) throws CategoryHasProductException {
        //判断该cid到底能删还是不能删?

        //判断该分类下 商品个数  只要大于0  就是不能删除
        int totalByCid = productDao.findTotalByCid(cid);
        if(totalByCid>0){
            //就是不能删除

            //抛出异常
            throw new CategoryHasProductException();


        }else{

            //才能够删除
            categoryDao.del(cid);
            clearCache();

        }
    }

    @Override
    public void save(Category category) {
        categoryDao.save(category);
        //现在的缓存数据过期了
        //缓存替换了 最新的
        clearCache();
    }

    @Override
    public Category findOne(String cid) {
        return categoryDao.findOne(cid);

    }

    @Override
    public void update(Category category) {
        categoryDao.update(category);
        clearCache();
    }

    private void clearCache() {
        //替代过期缓存
        //创建与redis数据库连接
        Jedis connection =null;
        try {
            connection = RedisUtil.getConnection();
            //缓存数据库没有 调用数据库查询
            List<Category> all = categoryDao.findAll();
            //缓存数据库里放一份  所以用JSONArray
            connection.set("day21_category", JSONArray.fromObject(all).toString());
        } finally{
            connection.close();
        }

    }

}

