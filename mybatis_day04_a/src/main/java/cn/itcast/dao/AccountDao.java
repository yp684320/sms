package cn.itcast.dao;

import cn.itcast.domain.Account;
import cn.itcast.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {
    //注解 查询账户下的用户信息
    //查询所有账户信息
    @Select(value = "select * from account")
    //注解映射
    @Results(value = {
            //id
            @Result(id = true,property = "id",column = "id"),
            //其他字段
            @Result(property = "uid",column = "uid"),
            @Result(property = "money",column = "money"),
            /*关联对象
            *property:关联对象的属性
            * JavaType:关联对象的字节码文件
            * one:配置对象 select :定位要关联的sql方法上  该接口的全限定名.方法名 fetchType:代表是否让关联对象的数据延时加载 取值FetchType.LAZY (延迟加载) FetchTypeEAGER(立即加载)
            * column:要传的参数
            * */
            @Result(property ="user" ,javaType = User.class, one = @One(select = "cn.itcast.dao.UserDao.findUserBy",fetchType = FetchType.LAZY),column = "uid")
    })
    public List<Account> findAccount();


    //根据用户的id查询所有账户信息
    @Select(value = "select * from account where uid = #{要传递用户的id}")
    public List<Account> findById(int id);
}
