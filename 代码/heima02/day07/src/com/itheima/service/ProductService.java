package com.itheima.service;

import com.itheima.dao.ProductDao;
import java.sql.SQLException;

public class ProductService {
    public String insert( int id, String pname, int price){
        ProductDao dao = new ProductDao();
        //调用方法
        try {
            int flag = dao.insert( id, pname, price);
            if (flag == 1) {
               return "添加成功";
            } else {
               return "添加失败";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //System.out.println("添加失败");
        }
        return "出现异常 ";

    }
}
