package hm_02dengluanli.Service;

import hm_02dengluanli.Dao.UserDao;

import java.sql.SQLException;

public class UserService {
    //提供登录功能
    public boolean login(String username,String password){
        //创建UserDao对象
        UserDao dao = new UserDao();
        try {//执行 查询的方法
            boolean user = dao.queryUserByUsernameAndPassword(username, password);
            //返回查询结果
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }//注册功能
    public boolean reg( String username,String password){
        //创建UserDao对象
        UserDao userDao = new UserDao();
        //执行添加方法
        try {
            boolean user = userDao.updateUser(username, password);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
