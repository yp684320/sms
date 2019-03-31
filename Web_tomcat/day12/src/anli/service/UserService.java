package anli.service;

import anli.dao.UserDao;
import anli.domain.User;
import org.junit.Test;

public class UserService {
    UserDao userDao = new UserDao();
    public void regist(User user) {

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

    public User login(String username, String password) {
        return userDao.findUserByUsernameAndPassword(username,password);

    }
}
