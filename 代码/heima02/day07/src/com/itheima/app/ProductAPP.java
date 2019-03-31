package com.itheima.app;

import com.itheima.service.ProductService;

public class ProductAPP {
    public static void main(String[] args) {
        int id = 0;
        String pname = "ÎÞ»¨¹û";
        int price = 23;

        ProductService service = new ProductService();
        String insert = service.insert(id, pname, price);
        System.out.println(insert);
    }
}
