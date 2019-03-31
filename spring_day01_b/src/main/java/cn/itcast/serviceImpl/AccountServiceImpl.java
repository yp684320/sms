package cn.itcast.serviceImpl;

import cn.itcast.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    /*spring提供了注入依赖(DI)
     *依赖注入:对该类中存在依赖关系的类或对象自动赋值
     * 简单属性  (String Integer  int )   复杂属性(数组 list map set )   对象
     * 赋值方式 有2中 :  构造器赋值   set方式赋值
     * */

 /* private String username;
    private Integer age;
    //构造器方式赋值
    public AccountServiceImpl(String username, Integer age) {
        this.username = username;
        this.age = age;
    }


    //set方式赋值

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public void save() {
        System.out.println(username + ":" + age);
    }*/


 //复杂属性赋值
    private List<String> list;
    //构造器方式赋值
  /*  public AccountServiceImpl(List<String> list) {
        this.list = list;
    }
*/
    public void setList(List<String> list) {
        this.list = list;
    }
    public void save() {
        System.out.println(list);
    }



}
