import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;


public class UserDaoImpl {

    @Test
    public static void save() {
        //创建执行者
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //编写sql语句
        String sql = "insert into user values('aaaa',null,null,null,null,null,null,null,null,null)";
        /*  private String uid;//用户id
    private String username;
    private String password;
    private String name;
    private String email;
    private Date birthday;
    private String gender;
    private int state;//激活状态  0未激活 1已激活
    private String code;//激活码
    private String remark;//扩展字段*/
        //执行语句

        try {
            qr.update(sql);
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
       save();
    }
    public static void run(){
        User user = new User();
        user.setPassword("123");
        user.setName("杰克");
        System.out.println(user.toString());
    }
}
