package hm01_daima;

import org.apache.commons.dbutils.QueryRunner;
import utils.C3P0Utils;

import java.sql.SQLException;
//删除数据
public class Demo01 {
    public static void main(String[] args) throws SQLException {
        //获得QueryRunnable对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //写sql语句
        String sql = "delete from product where pid = 14";
        int i = qr.update(sql);
        System.out.println(i+"行受影响");
    }
}
