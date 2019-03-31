package com.itheima;
import org.junit.Test;
import com.itheima.domain.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/*.xml")
//注意：classpath:只能读取本项目的类路径下的配置文件
//注意：classpath*: 可以读取本项目或者其他以来项目的类路径下的配置文件
//注意：junit测试，运行时引入的依赖执行的源码
//注意：maven的命令，运行时引入的依赖 执行时执行的是本地仓库中的jar包, 需要把依赖项目打包安装到本地仓库中
public class ServiceTest {
    @Autowired
    UserService userService;
    @Test
    public void test(){
        User user = userService.findById(1);
        System.out.println(user);
    }
}
