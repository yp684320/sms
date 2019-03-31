package com.tensquare.sms.listener;

import com.aliyuncs.exceptions.ClientException;
import com.tensquare.sms.util.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "sendsms")
public class SmsListener {

    @Autowired
    private SmsUtil smsUtil;

    @RabbitHandler
    public void handler(Map<String, String> map) throws Exception {
        System.out.println(map.get("mobile"));
        System.out.println(map.get("code"));

        //{"code":"1111"}
        //{\"code\":\"1111\"}
        smsUtil.sendSms(map.get("mobile"), "{\"code\":\"" + map.get("code") + "\"}");
    }
}
