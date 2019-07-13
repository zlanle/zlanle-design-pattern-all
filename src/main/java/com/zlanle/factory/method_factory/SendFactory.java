package com.zlanle.factory.method_factory;

import com.zlanle.factory.MailSender;
import com.zlanle.factory.Sender;
import com.zlanle.factory.SmsSender;

/**
 * 多个工厂方法模式
 *  对普通工厂方法改造，如果普通工厂传的字符串出错，就不能正确的创建对象
 *  而多个工厂方法模式是提供多个工厂方法，分别创建对象
 */
public class SendFactory {

    public Sender produceMail(){
        return new MailSender();
    }

    public Sender productSms(){
        return new SmsSender();
    }
}
