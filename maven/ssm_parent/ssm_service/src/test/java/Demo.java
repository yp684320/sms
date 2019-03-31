import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/*.xml")
public class Demo {
    @Autowired
    ProductService productService;
    @Test
    public void test(){
        /*List<Product> list = productService.findAll();
        for (Product product : list) {
            System.out.println(product);
        }*/
    }
}
