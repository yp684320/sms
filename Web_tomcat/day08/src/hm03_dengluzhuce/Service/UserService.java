package hm03_dengluzhuce.Service;

import hm03_dengluzhuce.Dao.UserDao;
import hm03_dengluzhuce.Domain.User;
import org.junit.Test;

import java.sql.SQLException;

public class UserService {

    //    @Test
//    public void run(){
//        User tom = new User("tom", "123");
//        boolean login = login(tom);
//        System.out.println(login);
//    }
    //提供登录功能
    public boolean login(User user){
        UserDao userDao = new UserDao();
        try {//判断是否 存在
            boolean user1 = userDao.queryUser(user);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
