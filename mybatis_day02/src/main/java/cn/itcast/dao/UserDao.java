package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;
/*保存用户
更新用户
删除用户
查询全部用户
根据id查询用户
模糊查询用户
统计用户数量
*/
public interface UserDao {
    //保存用户
    public void saveUser(User user);
    //更新用户 把小李改成老李
    public void updateUser(User user);
    //删除用户 把小李删除
    public void deleteUser(int id);
    //查询所有
    public List<User> findAll();
    //根据id查询用户
    public User findById(int id);
    //模糊查询用户
    public List<User> findLike(User user);
    //统计用户数量
    public int findCount();
    //映射配置文件
    public User findUser(int id);
}
