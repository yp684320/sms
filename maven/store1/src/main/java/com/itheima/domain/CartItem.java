package com.itheima.domain;
/*购物项*/
public class CartItem {
    private Product product;//关联商品
    private int count;//买几件
    private double subtotal;//小计

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSubtotal() {
        return product.getShop_price()*count;
    }
}
