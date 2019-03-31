package cn.itcast.dao;

import cn.itcast.domain.Account;
import cn.itcast.domain.User;
import cn.itcast.utils.SqlUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserDao {
    //注解查询所有
    @Select(value = "select * from user")
    public List<User> findAll();

    //注解 插入数据
    @Insert(value = "insert into user(username, sex,address) values(#{username},#{sex},#{address})")
    //返回插入数据的id值
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void saveUser(User user);

    //注解删除数据
    @Delete(value = "delete from user where id = #{这里是uid 可以随便写}")
    public void deleteUser(int id);

    //注解更新数据
    @Update(value = "update user set username = #{username} where id = #{id}")
    public void updateUser(User user);

    //注解 通过id查询用户
    @Select(value = "select * from user where id = #{随便写}")
    public User findUserById(int id);

    //注解 模糊查询数据
    @Select(value = "select * from user where username like #{username}")
    public List<User> findLike(User user);

    //注解 查询数据条数
    @Select(value = "select count(*) from user")
    public int findCount();

    //注解 映射配置文件查询(别名)
    @Select(value = "select u.id uid, u.username, u.sex, u.address from user u where id = #{随便写}")
    @Results(value = {
            //id映射字段
            @Result(id = true, property = "id", column = "uid"),
            //其他映射字段
            @Result(property = "username", column = "username"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "address", column = "address")
    })
    public User findUser(int id);

   //根据uid查询用户信息
    //注解查询
    @Select(value = "select * from user where id = #{账户传过来的uid}")
    public User findUserBy(int id);

    /*注解查询全部用户的所有账户信息
    * */
    @Select(value = "select * from user ")
    //映射
    @Results(value = {
            //id
            @Result(id = true,property = "id",column = "id"),
            //其他字段
            @Result(property = "username",column = "username"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "address",column = "address"),
            //关联对象
            @Result(property = "accounts",javaType = List.class,
            many =@Many(select = "cn.itcast.dao.AccountDao.findById",fetchType = FetchType.LAZY),column = "id")

    })
    public List<User> findAllUser();


    //条件查询
    //注解查询 只能自己拼接sql语句 然后返回
   // @Select(value = "select * from user where 1=1 and username = #{username} and sex = #{sex}")
   // @SelectProvider(type = SqlUtils.class,method = "querySql")
    @Select(value = " <script>\n" +
            "        select * from user\n" +
            "\t   <where>\n" +
            "\t\t<if test=\"username!=null and username!=''\">\n" +
            "            and username=#{username}\n" +
            "\t\t</if>\n" +
            "\t\t<if test=\"sex!=null and sex!=''\">\n" +
            "             and sex=#{sex}\n" +
            "\t\t</if>\n" +
            "\t  </where>\n" +
            "\t  </script>")
    public List<User> findCondition(User user);
}


