import cn.itheima.pojo.Customer;
import org.junit.Test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CustomerTest {
    @Test
    public void testAddCustomer()throws Exception{
        // 创建实体管理器工厂
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
        // 获取实体管理器
        EntityManager entityManager = factory.createEntityManager();
        // 获取事务管理器
        EntityTransaction transaction = entityManager.getTransaction();
            // 开启事务
            transaction.begin();
            // 创建实体类 设置数据
            Customer customer = new Customer();
            customer.setCustAddress("北京西二旗");
            customer.setCustIndustry("网上");
            customer.setCustLevel("哈哈");
            customer.setCustName("李飞");
            customer.setCustPhone("12344445555");
            customer.setCustSource("呵呵");
            // 保存实体类
            entityManager.persist(customer);
            // 提交事务
            transaction.commit();
            // 关闭事务管理器
            entityManager.close();
            // 关闭工厂
            factory.close();

        }
    }

