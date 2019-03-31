package hm01_daima;

import org.apache.commons.dbutils.QueryRunner;
import utils.C3P0Utils;

import java.sql.SQLException;

//改数据
public class Demo02 {
    public static void main(String[] args) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "update  product set  pname = ? ,price = ?,category_id = ? where pid = ?";
        Object[] params = {"花生","10","c006",13};
        int i = qr.update(sql,params);
        System.out.println(i);
    }
}
