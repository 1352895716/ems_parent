package com.zlp.sms;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName: SmsListener
 * @Description: TODO
 * @Autor:13528
 * @Date: 2020/2/14 14:48
 * @Version 1.0
 **/
@Component
public class SmsListener {

    @Autowired
    SmsUtil smsUtil;

    @JmsListener(destination = "sms")
    public void sendMessage(Map<String,String> map){
        try {
            System.out.println("map:"+map);
            /*SendSmsResponse response = smsUtil.sendSms(map.get("mobile"),
                    map.get("template_code"),
                    map.get("sign_name"),
                    map.get("param"));

            System.out.println("Code=" + response.getCode());
            System.out.println("Message=" + response.getMessage());
            System.out.println("RequestId=" + response.getRequestId());
            System.out.println("BizId=" + response.getBizId());*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
