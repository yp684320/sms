package com.itheima.dao;

import com.itheima.domain.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> findAll();

    void del(String cid);

    void save(Category category);

    Category findOne(String cid);

    void update(Category category);
}
