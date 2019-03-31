package com.itheima.service;

import com.itheima.AccountDao;
import com.itheima.util.C3P0Utils;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountService {
    public boolean transfer(String outName,String inName,double money){
        //调用Dao的方法
        AccountDao dao = new AccountDao();
        //获取连接
        Connection conn = null;
        try {
           conn=  C3P0Utils.getConnection();
           //开启事务
            conn.setAutoCommit(false);
            //调用Dao方法
           dao.accoutOut(conn,outName,money);
           dao.accountIn(conn,inName,money);
           //提交
            DbUtils.commitAndCloseQuietly(conn);
            System.out.println("转账成功");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("转账失败");
            DbUtils.rollbackAndCloseQuietly(conn);
            return false;
        }
    }
}
