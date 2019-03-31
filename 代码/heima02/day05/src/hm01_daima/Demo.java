package hm01_daima;

import org.apache.commons.dbutils.QueryRunner;
import utils.C3P0Utils;

import javax.sql.DataSource;
import java.sql.SQLException;
//添加数据
public class Demo {
    public static void main(String[] args) throws SQLException {
      //获取连接池
        DataSource ds = C3P0Utils.getDataSource();
        //创建queryRunner对象
        QueryRunner qr = new QueryRunner(ds);
        //写sql语句
        String sql = "insert into product  values (null,'果酒',5000,'c001')";
        int i = qr.update(sql);
        System.out.println(i+"行 受影响");
    }
}
