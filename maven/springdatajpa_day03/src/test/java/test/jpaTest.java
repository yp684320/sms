package test;

import com.itheima.jpa.dao.*;
import com.itheima.jpa.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class jpaTest {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private CustomerEtxDao customerEtxDao;
    @Autowired
    private LinkManDao linkManDao;
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysRoleDao sysRoleDao;
    // 一对一的CRUD
    // 添加数据
    @Test
    @Transactional
    @Commit
    public void one2One(){
        Customer customer = new Customer();
        customer.setCustName("刘备");
        customer.setCustAge("33");
        CustomerEtx customerEtx = new CustomerEtx();
        customerEtx.setCustomerEtxName("刘备的信息");
        customer.setCustomerEtx(customerEtx);
        customerDao.save(customer);
    }
    // 通过id查询
    @Test
    public void one2OneTest(){
        Customer customer = customerDao.findById(1l).get();
        System.out.println(customer.getCustName());
        System.out.println(customer.getCustomerEtx().getCustomerEtxName());
    }
    // 删除
    @Test
    @Transactional
    @Commit
    public void one2OneDel(){
        customerDao.deleteById(1l);
    }
    // 一对多的CRUD
    // 添加数据
    @Test
    @Transactional
    @Commit
    public void one2ManyAdd(){
        Customer customer = new Customer();
        customer.setCustName("张飞");
        customer.setCustAge("35");

        LinkMan linkMan1 = new LinkMan();
        linkMan1.setLinkManName("李飞");
        linkMan1.setLinkManAddress("北京");
        linkMan1.setCustomer(customer);

        LinkMan linkMan2 = new LinkMan();
        linkMan2.setLinkManName("王凯");
        linkMan2.setLinkManAddress("上海");
        linkMan2.setCustomer(customer);

        customer.getLinkManSet().add(linkMan1);
        customer.getLinkManSet().add(linkMan2);
        //customerDao.save(customer);
        linkManDao.save(linkMan1);
    }
    @Test
    @Transactional
    @Commit
    public void one2ManyDel(){
       // customerDao.deleteById(1l);
        linkManDao.deleteById(3l);
    }
    @Test
    public void one2ManyQuery(){
//        Customer customer = customerDao.findById(3l).get();
//        System.out.println(customer.getCustName());
//        customer.getLinkManSet().forEach(e-> System.out.println(e));

        LinkMan linkMan = linkManDao.findById(5l).get();
        System.out.println(linkMan.getCustomer());
        linkMan.getCustomer().getLinkManSet().forEach(e -> System.out.println(e));
    }
    // 多对多CRUD
    @Test
    @Transactional
    @Commit
    public void many2MangAdd(){
        SysUser sysUser1 = new SysUser();
        sysUser1.setUsername("张三");
        sysUser1.setAddress("育新");
        SysUser sysUser2 = new SysUser();
        sysUser2.setUsername("张四");
        sysUser2.setAddress("育新");

        SysRole sysRole1 = new SysRole();
        sysRole1.setRoleName("学生");
        sysRole1.setRoleAddress("北京");
        SysRole sysRole2 = new SysRole();
        sysRole2.setRoleName("班长");
        sysRole2.setRoleAddress("北京");

        sysUser1.getSysRoleSet().add(sysRole1);
        sysUser1.getSysRoleSet().add(sysRole2);
        sysUser2.getSysRoleSet().add(sysRole1);
        sysUser2.getSysRoleSet().add(sysRole2);

        sysUserDao.save(sysUser1);
        sysUserDao.save(sysUser2);
    }
    @Test
    @Transactional
    @Commit
    public void many2ManyDel(){
        sysUserDao.deleteById(1l);
    }

}
