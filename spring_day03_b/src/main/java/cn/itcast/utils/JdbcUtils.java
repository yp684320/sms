package cn.itcast.utils;

import java.sql.Connection;

public class JdbcUtils {
  private static ThreadLocal<Connection> tl =  new ThreadLocal<Connection>();
  public static ThreadLocal<Connection> getTl(){
      return tl;
  }


}
