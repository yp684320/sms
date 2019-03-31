
package cn.itcast.core.controller;

        import cn.itcast.core.dao.UserService;
        import com.alibaba.dubbo.config.annotation.Reference;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("/showName.do")
//    @ResponseBody
    public String showName(){
        return userService.showName();
    }
}
