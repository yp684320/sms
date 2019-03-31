package com.itheima.view;

import com.itheima.service.AccountService;

public class AccountAPP {
    public static void main(String[] args) {
        //定义人
        String outName = "rose";
        String inName = "tom";
        double money = 200;
        //创建service
        AccountService accountService = new AccountService();
        boolean success = accountService.transfer(outName, inName, money);
        if (success) {
            System.out.println("恭喜您,转账成功");
        } else {
            System.out.println("转账失败");
        }

    }
}
