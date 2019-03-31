package cn.itcast.utils;

import cn.itcast.domain.Configuration;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 执行器的类，专门用于执行SQL语句
 * @author Administrator
 *
 */
public class Executor {
	private Configuration cfg ;
	public Executor(Configuration cfg) {
		this.cfg = cfg;
	}

	//执行的是查询语句
	public  <E> List<E> executeQuery(String sql,String resultType) throws Exception {
		//jdbc操作查询数据库
		Connection conn = null;
		
		try {
			Class.forName(cfg.getDriver());
			conn = DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			pst = conn.prepareStatement(sql);//创建PreparedStatement
			rs = pst.executeQuery();//执行sql获取结果集
			//封装对象
			List list = new ArrayList();
			//1.反射（创建对象，反射调用set方法）
			Class clazz = Class.forName(resultType);
			Method[] methods = clazz.getDeclaredMethods();
			
			//2.元数据（数据库有关的，可以获取数据库查询结果的所有字段名）
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount(); //得到字段的数量
			
			//获取所有字段的名称
			List<String> columnNames = new ArrayList();
			
			for(int i=1;i<=columnCount;i++) {
				columnNames.add(metaData.getColumnName(i));//获取索引号为i的字段名称
			}
			
			while(rs.next()) {
				//创建对象
				Object object = clazz.newInstance();
				//反射赋值
				for (String columnName : columnNames) {
					for (Method method : methods) {
						//setUsername  --  username
						if(method.getName().equalsIgnoreCase("set" + columnName)) {
							method.invoke(object, rs.getObject(columnName));
						}
					}
				}
				//存入list集合
				list.add(object);
			}
			
			return list;
		}finally {
			rs.close();
			pst.close();
			conn.close();
		}
	}
	/**
	 * 还可以定义执行更新的方法，这样就可以完成新增，更新，保存操作 
	 */
	public int executeUpdate(String sql,String ... params) {
		//此处省略。。。。。
		return 0;
	}
}
