package com.itheima.proxy.wrapper;

public class User {
    private int id;
    private String driverName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setDriverName("小明");
        user.setId(1);
    }
}
