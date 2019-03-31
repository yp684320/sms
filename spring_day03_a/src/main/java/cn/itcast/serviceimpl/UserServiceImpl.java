package cn.itcast.serviceimpl;

import cn.itcast.srevice.UserService;

public class UserServiceImpl implements UserService {
    public String save(String msg) {
        System.out.println("save....");
        //int i= 1/0;//测试异常增强
        return "123zxc";
    }

    public void delete() {

    }
}
