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
    //注解查询账户下的用户所有信息
    @Select(value = "select * from account")
    //关联对象的映射
    @Results(value ={
            //id
            @Result(id = true ,property = "id",column = "id"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "money",column = "money"),
            //关联对象
            /*property:关联对象的属性
            * JavaType:关联对象的字节码
            * one:配置对象  select:定位到关联对象的sql上 (该接口的全限定名.方法名)  FetchType:代表是否让关联对象的数据延时加载 取值FetchType.LAZY (延时加载)FetchType.EAGER(立即加载)
            * column:要传的参数*/
            @Result(property = "user",javaType = User.class,
            one = @One(select = "cn.itcast.dao.UserDao.findUserById",fetchType = FetchType.LAZY),column = "uid")
    })
    public List<Account> findAccountByUser();
}
