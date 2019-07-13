package com.zlanle.factory;

import com.zlanle.factory.Sender;

public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("我是发送邮件的");
    }
}
