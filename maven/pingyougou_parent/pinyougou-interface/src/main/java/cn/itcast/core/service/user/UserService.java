package cn.itcast.core.service.user;

import cn.itcast.core.pojo.user.User;

public interface UserService {

    /**
     * 获取短信验证码
     * @param phone
     */
    public void sendCode(String phone);

    /**
     * 用户注册 保存
     * @param smscode
     * @param user
     */
    public void add(String smscode , User user);
}
