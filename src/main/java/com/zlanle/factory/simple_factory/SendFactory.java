package com.zlanle.factory.simple_factory;

import com.zlanle.factory.MailSender;
import com.zlanle.factory.Sender;
import com.zlanle.factory.SmsSender;

/**
 * 普通工厂方法模式
 *  对实现了同一接口的一些类进行实例的创建
 */
public class SendFactory {

    public Sender produce(String type){
        if ("mail".equals(type)){
            return new MailSender();
        }else if ("sms".equals(type)){
            return new SmsSender();
        }else{
            return null;
        }
    }
}
