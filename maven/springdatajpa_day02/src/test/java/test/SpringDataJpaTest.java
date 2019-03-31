package test;

import com.itheima.jpa.dao.CustomerDao;
import com.itheima.jpa.pojo.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringDataJpaTest {
    @Autowired
    private CustomerDao customerDao;
    // 根据id查询
    @Test
    public void findCustomerById(){
        Customer customer = customerDao.getOne(10l);
        System.out.println(customer);
    }
    // 添加数据
    @Test
    public void test(){
        Customer customer = new Customer();
        customer.setCustAddress("1");
        customer.setCustName("哈哈哈");
        //新增操作,先执行查询,如果不存在进行新增
        customerDao.save(customer);
    }
    // 更新数据
    @Test
    public void test1(){
        Customer customer = customerDao.getOne(13l);
        customer.setCustName("李华");
        //修改操作,先执行查询,如果存在进行修改
        customerDao.save(customer);
    }
    // 删除数据
    @Test
    public void test2(){
        customerDao.deleteById(26l);
    }
    // 查询所有
    @Test
    public void test3(){
        List<Customer> list = customerDao.findAll();
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }
    // 查询数据库表的数据条数
    @Test
    public void test4(){
        long count = customerDao.count();
        System.out.println(count);
    }
    // 查询数据是否存在
    @Test
    public void test5(){
        boolean flag = customerDao.existsById(15l);
        System.out.println(flag);
    }
    // 分页查询
    @Test
    public void test6(){
        // 第一个参数是从哪一页开始查询,数是从0开始
        // 第二个参数是每页显示的条数
        PageRequest pageRequest = PageRequest.of(1, 3);
       customerDao.findAll(pageRequest).forEach(e -> System.out.println(e));
    }
    // 排序
    @Test
    public void test7(){
        Sort sort = new Sort(Sort.Direction.DESC, "custId");
        customerDao.findAll(sort).forEach(e -> System.out.println(e));
    }
}
