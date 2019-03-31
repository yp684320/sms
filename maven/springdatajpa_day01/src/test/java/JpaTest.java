import cn.itheima.pojo.Customer;
import cn.itheima.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JpaTest {
    @Test
    // 添加数据
    public void createTest() {
        // 获取管理器
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 获取事务管理器
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            // 开启事务
            transaction.begin();
            for (int i = 0; i < 10; i++) {
                Customer customer = new Customer();
                customer.setCustSource("上海" + i);
                customer.setCustPhone("13355556666");
                customer.setCustName("王凯" + i);
                customer.setCustLevel("哈哈");
                customer.setCustAddress("北京" + i);
                entityManager.persist(customer);
            }
            // 提价事务
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // 回滚事务
            transaction.rollback();
        } finally {
            // 释放资源
            entityManager.close();
        }
    }

    // 删除数据
    @Test
    public void removeCustomer() {
        // 创建管理器
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 获取事务管理器
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            // 开启事务
            transaction.begin();
            // 根据id查询用户信息
            Customer customer = entityManager.find(Customer.class, 20l);
            // 根据id删除用户信息
            entityManager.remove(customer);
            // 提交事务
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // 回滚事务
            transaction.rollback();
        } finally {
            // 释放资源
            entityManager.close();
        }

    }

    // 修改数据
    @Test
    public void updateCustomer() {
        // 获取管理者
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 获取事务管理者
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            // 开启事务
            transaction.begin();
            Customer customer = entityManager.find(Customer.class, 19l);
            customer.setCustName("武松");
            entityManager.merge(customer);
            // 提交事务
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // 回滚事务
            transaction.rollback();
        } finally {
            // 释放资源
            entityManager.close();
        }


    }

    // 根据id查询
    @Test
    public void findById() {
        // 创建管理者
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 通过id查询
        Customer customer = entityManager.find(Customer.class, 19l);
        System.out.println(customer);
        // 释放资源
        entityManager.close();
    }

    // 根据id查询
    @Test
    public void findById2() {
        // 创建管理者
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 通过id查询
        Customer customer = entityManager.getReference(Customer.class, 19l);
        System.out.println(customer);
        // 释放资源
        entityManager.close();
    }

    // 查询所有
    @Test
    public void test() {
        // 创建管理者
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 查询所有
        Query query = entityManager.createQuery("from Customer ");
        List list = query.getResultList();
        // 遍历结合
        for (Object o : list) {
            System.out.println(o);
        }
        // 释放资源
        entityManager.close();
    }

    // 分页查询
    @Test
    public void test1() {
        // 创建管理者
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 查询所有
        Query query = entityManager.createQuery("from Customer ");
        query.setFirstResult(3);
        query.setMaxResults(3);
        List list = query.getResultList();
        // 遍历结合
        for (Object o : list) {
            System.out.println(o);
        }
        // 释放资源
        entityManager.close();
    }

    // 带条件分页查询
    @Test
    public void test2() {
        // 创建管理者
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 查询
        Query query = entityManager.createQuery("from Customer where custName like ? ");
        query.setParameter(1, "%凯%");
        // 从第几条数据查
        query.setFirstResult(3);
        // 每页显示几条数据
        query.setMaxResults(3);
        List list = query.getResultList();
        // 遍历结合
        for (Object o : list) {
            System.out.println(o);
        }
        // 释放资源
        entityManager.close();
    }

    @Test
    public void test3() {
        // 创建管理者
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 查询
        Query query = entityManager.createQuery("from Customer where custName like ? ");
        query.setParameter(1, "%松%");
        List list = query.getResultList();
        for (Object o : list) {
            System.out.println(o);
        }
        // 释放资源
        entityManager.close();
    }

    // 带条件分页查询 并倒序排列
    @Test
    public void test4() {
        // 创建管理者
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 查询
        Query query = entityManager.createQuery("from Customer where custName like ? order by custId desc");
        query.setParameter(1, "%凯%");
        // 从第几条数据查
        query.setFirstResult(3);
        // 每页显示几条数据
        query.setMaxResults(3);
        List list = query.getResultList();
        // 遍历结合
        for (Object o : list) {
            System.out.println(o);
        }
        // 释放资源
        entityManager.close();
    }

    // 查询数据的条数
    @Test
    public void test5() {
        // 创建管理者
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 查询
        Query query = entityManager.createQuery("select count(*) from Customer where custName like ? ");
        query.setParameter(1, "%凯%");
        Object count = query.getSingleResult();
        System.out.println(count);
        // 释放资源
        entityManager.close();
    }

    // 修改用户
    @Test
    public void test6() {
        // 创建管理者
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 获取还无管理者
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            // 开启事务
            transaction.begin();
            Query query = entityManager.createQuery("update Customer set custName = ? where custId = ?");
            query.setParameter(1, "李飞");
            query.setParameter(2, 15l);
            int update = query.executeUpdate();
            System.out.println(update);
            // 提交事务
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // 回滚事务
            transaction.rollback();
        } finally {
            // 释放资源
            entityManager.close();
        }
    }

    // 删除数据
    @Test
    public void test7() {
        // 创建管理者
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 获取还无管理者
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            // 开启事务
            transaction.begin();
            Query query = entityManager.createQuery("delete Customer where custId = ?");
            query.setParameter(1, 14l);
            int update = query.executeUpdate();
            System.out.println(update);
            // 提交事务
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // 回滚事务
            transaction.rollback();
        } finally {
            // 释放资源
            entityManager.close();
        }
    }

    // 使用sql语句进行CRUD
    @Test
    public void addTest() {
        // 创建管理者
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 获取事务管理者
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            // 开启事务
            transaction.begin();
            String sql = "INSERT INTO `spring-data`.`cst_customer` (`cust_address`,`cust_industry`,`cust_level`,`cust_name`,`cust_phone`,`cust_source`) VALUES(?,?,?,?,?,?)";
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter(1, "北京西城");
            query.setParameter(2, "IT");
            query.setParameter(3, "普通");
            query.setParameter(4, "张三");
            query.setParameter(5, "15888888888");
            query.setParameter(6, "校招");
            int i = query.executeUpdate();
            System.out.println(i);
            // 提交事务
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // 回滚事务
            transaction.rollback();
        } finally {
            // 释放资源
            entityManager.close();
        }

    }

}