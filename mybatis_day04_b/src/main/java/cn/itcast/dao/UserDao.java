package cn.itcast.dao;

import cn.itcast.domain.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    //根据账户信息传过来的uid查询用户信息
    @Select(value = "select * from user where id = #{传过来的id}")
    public User findUserById(int id);
}
