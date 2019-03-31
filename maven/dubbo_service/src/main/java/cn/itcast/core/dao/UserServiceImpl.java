package cn.itcast.core.dao;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String showName() {
        return "hello dubbo";
    }
}
