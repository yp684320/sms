package com.itheima.constants;

public interface Global {
    /**
     * 商品不热门
     */
    int PRODUCT_IS_NOT_HOT=0;
    /**
     * 商品热门
     */
    int PRODUCT_IS_HOT=1;

    /**
     * 商品上架
     */
    int PRODUCT_FLAG_ON=0;
    /**
     * 商品未上架
     */
    int PRODUCT_FLAG_OFF=1;
    /**
     * 订单状态之未付款
     */
    int ORDER_STATE_WEIFUKUAN=0;
    /**
     * 订单状态之已付款
     */
    int ORDER_STATE_YIFUKUAN=1;
    /**
     * 订单状态之已发货
     */
    int ORDER_STATE_YIFAHUO=2;
    /**
     * 订单状态之已完成
     */
    int ORDER_STATE_YIWANCHENG=3;
}
