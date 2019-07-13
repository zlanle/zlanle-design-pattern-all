package com.zlanle.factory.static_factory;

import com.zlanle.factory.MailSender;
import com.zlanle.factory.Sender;
import com.zlanle.factory.SmsSender;

/**
 * 静态工厂方法模式
 * 方法都为静态的，不需要创建实例，可以直接调用
 */
public class SendFactory {

    public static Sender produceMail(){
        return new MailSender();
    }

    public static Sender produceSms(){
        return new SmsSender();
    }
}
