package service;

import dao.UserDao;
import domain.User;
import org.junit.Test;

public class UserService {

    public void regist(User user) {
        UserDao userDao = new UserDao();
        userDao.save(user);
    }
    @Test
    public void test(){
//        private int id;
//        private String username;
//        private String password;
//
//        private String email;
//        private String name;
//        private String gender;
//
//        private String birthday;
        User user = new User();
        user.setId(3);
        user.setUsername("kk");
        user.setPassword("1243");
        regist(user);

    }
}
