package cn.itcast.core.controller.user;

import cn.itcast.core.entity.Result;
import cn.itcast.core.pojo.user.User;
import cn.itcast.core.service.user.UserService;
import cn.itcast.core.utils.phone.PhoneFormatCheckUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;

    /**
     * 获取短信验证码
     * @param phone
     * @return
     */
    @RequestMapping("/sendCode.do")
    public Result sendCode(String phone){
        try {
            //验证手机号是否正确
            boolean phoneLegal = PhoneFormatCheckUtils.isChinaPhoneLegal(phone);
            if (!phoneLegal) {
                return new Result(false,"手机号不合法");
            }
            userService.sendCode(phone);
            return new Result(true, "短信发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "短信发送失败");
        }
    }

    /**
     * 用户注册  保存
     * @param smscode
     * @param user
     * @return
     */
    @RequestMapping("add.do")
    public Result add(String smscode , @RequestBody User user){
        try {
            userService.add(smscode,user);
            return new Result(true,"保存成功");

        } catch (RuntimeException e) {
            e.printStackTrace();
            return new Result(false,e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"保存失败");
        }
    }
}
