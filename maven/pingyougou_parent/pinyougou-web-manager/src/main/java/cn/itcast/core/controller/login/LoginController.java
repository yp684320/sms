package cn.itcast.core.controller.login;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
    /**
     * 显示当前登录人
     * @return
     */
    @RequestMapping("/showName.do")
    public Map<String,String> showName(){
        //从springsecurity容器中获取用户信息
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        HashMap<String, String> map = new HashMap<>();
        map.put("username",username);
        return map;
    }
}
