package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

public interface UserDao {
    //查询所有
   public List<User> findAll();
   //插入一条数据
    public void saveUser(User user);
    //修改数据
    public void updateUser(User user);
    //删除数据
    public void deleteUser(int id);
    //模糊查询
    public List<User> findLike(User user);
    //根据 id查询
    public User findById(int id);
    //映射 根据id查询
    public User findUser(int id);
}
