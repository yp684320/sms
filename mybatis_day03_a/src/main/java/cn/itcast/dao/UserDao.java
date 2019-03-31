package cn.itcast.dao;

import cn.itcast.domain.POJOUser;
import cn.itcast.domain.User;

import java.util.ArrayList;
import java.util.List;

public interface UserDao {

   //查询所有用户
    public List<User> findUser();
    //根据username 和 sex神经性查询
    public List<User> findUserBy(User user);
    //包含数据查询      数组
    public List<User> findUserArr(int[] arr);
    //包含查询数据      集合
    public List<User> findUserList(List list);
    //包含查询      pojo对象
    public List<User> findPOJOUser(POJOUser user);
}
