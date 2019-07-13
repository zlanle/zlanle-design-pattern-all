package com.zlanle.factory.abstract_factory;

import com.zlanle.factory.MailSender;
import com.zlanle.factory.Sender;

/**
 * 抽象工厂模式
 * 扩展性好，增加新的功能，直接增加新的工厂类就可以了
 */
public class SendMailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
