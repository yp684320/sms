package cn.itcast.utils;

import cn.itcast.domain.User;


public class SqlUtils {
    public String querySql(User user){
        String sql = "select * from user where 1=1";
        if (user.getUsername()!=null && user.getUsername()!="") {
            sql = sql + " and username = #{username}";
        }
        if (user.getSex()!=null && user.getSex()!="") {
            sql+=" and sex = #{sex}";
        }
        System.out.println(sql.toString());
        return sql.toString();

    }
}
