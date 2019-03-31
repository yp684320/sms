import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
public class Demo {
    @Autowired
    ProductDao productDao;
    @Test
    public void test(){
       /* List<Product> list = productDao.findAll();
        for (Product product : list) {
            System.out.println(product);
        }*/
    }
}
