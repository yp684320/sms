package com.itheima.service;


import com.itheima.domain.Category;
import com.itheima.exception.CategoryHasProductException;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

   // void del(String cid) throws CategoryHasProductException;

    void save(Category category);


    Category findOne(String cid);

    void update(Category category);
    void del(String cid) throws CategoryHasProductException;
}
