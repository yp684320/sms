package com.itheima.domain.dao;

import com.itheima.domain.Book;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    public List<Book> findAll(){
        //创建一个List集合
        ArrayList<Book> books = new ArrayList<Book>();
        Connection conn = null;
        Statement st = null;
        ResultSet rst = null;
        //1,注册数据库驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/springdb";
        String username = "root";
        String password = "root";
        try {
            //2,获取连接
            conn = DriverManager.getConnection(url, username, password);
            //3,获取Statement对象
             st = conn.createStatement();
            //4,执行sql语句  获取结果集
            String sql = "select * from book";
             rst = st.executeQuery(sql);
            //5,处理结果集  把结果集的内容封装到集合中
            while(rst.next()){
                //有一条记录说明有一个book对象
                Book book = new Book();
                //封装book对象
                int id = rst.getInt("id");
                book.setId(id);
                String name = rst.getString("name");
                book.setName(name);
                double price = rst.getDouble("price");
                book.setPrice(price);
                book.setPic(rst.getString("pic"));
                book.setDescription(rst.getString("description"));
                //把book添加到集合中
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6,释放资源
            try {
                rst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

     return books;
    }
}
