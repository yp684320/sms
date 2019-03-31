package com.itheima.domain;

import java.util.Collection;
import java.util.HashMap;

import java.util.Map;

//购物车
public class Cart {
   private Map<String,CartItem> items = new HashMap<>();//购物项集合
    private double total;//总金额

    public Collection< CartItem> getItems() {
        return items.values();
    }

    public void setItems(Map<String, CartItem> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    //添加购物项
    public void addItem(CartItem item){
        //集合中添加购物项
           //获取商品pid
        String pid = item.getProduct().getPid();
        //判断原来是否有该商品
        if (items.containsKey(pid)) {
            //有  数量加一
            //获取原来 就有的
            CartItem oriItem = items.get(pid);
            oriItem.setCount(oriItem.getCount()+item.getCount());
        }else{
            //没有  直接放进去
            items.put(pid,item);
        }
        //计算总金额
        total+=item.getSubtotal();

    }
    //删除购物项
    public void removeItrm(String pid ){
        //从集合中删除
        CartItem remove = items.remove(pid);
        //总金额减去删除的
        total-=remove.getSubtotal();

    }

    //清空购物车
    public void clear(){
        //从集合中清空
        items.clear();
        //总金额为0
        total=0.0;
    }

}
